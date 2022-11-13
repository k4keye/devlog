package com.main.server.controller;


import com.main.server.common.response.ResponseService;
import com.main.server.common.response.enums.CommonErrorCode;
import com.main.server.common.response.result.LinksResult;
import com.main.server.common.response.result.SingleResult;
import com.main.server.controller.dto.request.PatchRequest;
import com.main.server.controller.dto.response.MemberDto;
import com.main.server.domain.Member;
import com.main.server.service.member.MemberService;
import com.main.server.service.member.MemberPatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberPatchService memberPatchService;
    private final ResponseService responseService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ResponseEntity fetchMembers(Pageable pageable){
        //@RequestParam("page") Integer page, @RequestParam("size") Integer size
        Page<MemberDto> members = memberService.fetchAllMember(pageable).map(MemberDto::new);

        List<LinksResult> links = new ArrayList<>();
        links.add(new LinksResult("detail","/member/{id}"));

        SingleResult<Page<MemberDto>> responseBody = responseService.getResult(members, links);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity fetchMember(@PathVariable String id){

        Member authMember = memberService.getAuthMember();

        if(authMember.isAdmin() || authMember.getLoginID().equals(id)){
            long startTime = System.currentTimeMillis();
            Member member = memberService.fetchMember(id);
            long endTime = System.currentTimeMillis();
            System.out.println("response cache time  = " + (endTime - startTime));
            return ResponseEntity.status(HttpStatus.CREATED).body(responseService.getResult(new MemberDto(member)));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));

    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable String id){

        Member authMember = memberService.getAuthMember();

        if(authMember.isAdmin() || authMember.getLoginID().equals(id)){
            memberService.delete();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseService.getSuccessResult());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity patchMember(@PathVariable String id , @RequestBody PatchRequest[] patchRequest){

        Member authMember = memberService.getAuthMember();

        if(!authMember.isAdmin() && !authMember.getLoginID().equals(id)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));
        }

        Member member = memberService.fetchMember(id);
        try{

            for (PatchRequest request : patchRequest) {
                memberPatchService.patch(member,request.getOp(),request.getPath(),request.getValue());
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseService.getFailResult(CommonErrorCode.ACCESS_DENIAL));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseService.getFailResult(CommonErrorCode.CONFLICT));
    }

}
