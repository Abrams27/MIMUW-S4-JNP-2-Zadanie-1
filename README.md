# MIMUW-S4-JNP-2-Zadanie-1
Małe zadanko z JNP 2 (architektura) - integracja maila z kafką

## Mail:
https://camel.apache.org/components/latest/mail-component.html

## Kafka:
https://camel.apache.org/components/latest/kafka-component.html

# Budowanie:
```
mvn clean install
```

# Odpalanie:
```
export MAILROUTE_HOST="adres servera poczty przychodzącej (imap)" # np imap.wp.pl
export MAILROUTE_PASSWORD="twoje hasło"
export MAILROUTE_USERNAME="nazwa użytkownika" # np ktos@wp.pl
mvn spring-boot:run
```
