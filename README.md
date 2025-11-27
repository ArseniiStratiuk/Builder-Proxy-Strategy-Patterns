# OOAD Lab 11

Small Java 17 Maven project for practicing key OOAD patterns:

- **Task 1** – Builder pattern with Lombok for a flexible `User` model.
- **Task 2** – Strategy-based mailing system (`Client`, `MailInfo`, `MailBox`, `MailSender`).
- **Task 3** – Proxy pattern (`ProxyImage` defers heavy `RealImage` initialization).

## Building & Testing

```sh
mvn -q verify
```

The command compiles sources, runs unit tests (JUnit 5), and checks coverage hooks used by CI.

## Running Task 3 Demo

```sh
mvn -q -DskipTests compile
java -cp target/classes apps.ucu.ooad.task3.Task3Demo
```

A sample PNG is generated automatically (under `target/`) and displayed via the proxy to showcase lazy loading.

## MailJet Example

`apps.ucu.ooad.Main` sends a sample email through MailJet. Set API credentials before running:

```sh
set MAILJET_API_KEY=yourKey
set MAILJET_API_SECRET=yourSecret
mvn -q -DskipTests exec:java -Dexec.mainClass=apps.ucu.ooad.Main
```

(Use `export` on Unix shells.) Credentials are not stored in the repo; GitHub Actions does not run this sample.
