# kafkamail
Simple kafka and mail integration using camel:

- [mail](https://camel.apache.org/components/latest/mail-component.html)
- [kafka](https://camel.apache.org/components/latest/kafka-component.html)

---

# building
```
mvn clean install
```

# running
```
export MAILROUTE_HOST="incomming mail server address (imap)" # e.g. imap.wp.pl
export MAILROUTE_PASSWORD="user password"
export MAILROUTE_USERNAME="username" # e.g. user@wp.pl
mvn spring-boot:run
```
