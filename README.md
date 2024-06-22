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
Download Apache Skywalking 8.3.0
```bash
wget https://archive.apache.org/dist/skywalking/8.3.0/apache-skywalking-apm-8.3.0.tar.gz
```
Extract the downloaded archive
```bash
tar -zxvf apache-skywalking-apm-8.3.0.tar.gz
```
