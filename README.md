# Devlog

## tool
- IntelliJ
- Postman
- DBeaver
- Git



## Environment
### Active Port

| name          | port       |
|---------------|------------|
| main server   | 8081       |
| main mariadb  | 4445       |
| redis         | 6379       |
| zookeeper     | 2181       |
| kafka         | 9092       |
| elasticsearch | 9200, 9300 |
| filebeat      | 5044       |
| kibana        | 5601       |



### Docker Compose setup
You will need to install Docker and docker-compose.

a Docker Compose setup is provided. It comes with the following databases:

- mariadb:10.8.3
- redis:7.0.4

and kafka :
- kafka:2.12-2.0.1
- zookeeper:3.4.6

and ELK :
- filebeat:7.10.2
- logstash:7.11.2-arm64
- elasticsearch:7.10.2-arm64
- kibana:7.10.2


To launch the database and kafka and ELK containers:

```
 $ docker-compose up -d
```

## Usage

### kafka
topic list
```
./opt/kafka_2.12-2.0.1/bin/kafka-topics.sh --list --zookeeper zookeeper:2181
```

topic create
```
./opt/kafka_2.12-2.0.1/bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic message-topic
```

topic message send
```
./opt/kafka_2.12-2.0.1/bin/kafka-console-producer.sh --topic message-topic --broker-list localhost:9092
```

### redis
```
> redis-cli 
> info
> keys * 
> flushall 
```


## ETC
http://localhost:8081/swagger-ui/index.html#/ </br>
http://localhost:5601/app/home#/
