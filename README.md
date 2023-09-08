# Демо-проект по автоматизации тестирования API для <p align="center"> [<img src="media/logos/Reqres.jpg">](https://reqres.in/) </p>

> [Reqres](https://reqres.in/) - тренировочная платформа для QA-студентов и инженеров.

____

> ## :ballot_box_with_check: <a name="Содержание">**Содержание:**</a>

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram с помощью бота</a>

____

<a id="tools"></a>
> ## :ballot_box_with_check: <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

<p  align="center"

<code><a href="https://www.java.com/"><img width="5%" title="Java" src="media/logos/Java.svg"></a></code>
<code><a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/logos/Intellij_IDEA.svg"></a></code>
<code><a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/logos/Gradle.svg"></code></a>
<code><a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="media/logos/JUnit5.svg"></a></code>
<code><a href="https://rest-assured.io/"><img width="5%" title="REST Assured" src="media/logos/RestAssured.svg"></a></code>
<code><a href="https://github.com/"><img width="5%" title="GitHub" src="media/logos/GitHub.svg"></a></code>
<code><a href="https://github.com/allure-framework"><img width="5%" title="Allure Report" src="media/logos/Allure.svg"></a></code>
<code><a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logos/Allure_TO.svg"></a></code>
<code><a href="https://www.jenkins.io"><img width="5%" title="Jenkins" src="media/logos/Jenkins.svg"></a></code>
<code><a href="https://www.atlassian.com/software/jira"><img width="5%" title="Jira" src="media/logos/Jira.svg"></a></code>
<code><a href="https://web.telegram.org"><img width="5%" title="Telegram" src="media/logos/Telegram.svg"></a></code>

</p>

- В данном проекте автотесты написаны на <code>Java</code> с использованием
  фреймворков [REST Assured](https://rest-assured.io/) и [JUnit 5](https://junit.org/junit5/).
- Для сборки проекта был использован [Gradle](https://gradle.org/).
- Удаленный запуск реализован в [Jenkins](https://jenkins.autotests.cloud/) с формированием <code>Allure</code>-отчета.
- Подключена отправка уведомлений о результатах запуска сборки в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с [Allure TestOps](https://allure.autotests.cloud/) и [Jira](https://jira.autotests.cloud/).

____

<a id="cases"></a>
> ## :ballot_box_with_check: <a name="Примеры автоматизированных тест-кейсов">Примеры автоматизированных тест-кейсов:</a>

- Проверка возможности получения списков пользователей и ресурсов сервиса с информацией о них на одной и на нескольких страницах;
- Проверка возможности получения половины списка пользователей с "delayed response" с указанием любого номера страницы;
- Получение пустого списка пользователей и ресурсов;
- Проверка возможности получения информации об одном пользователе или ресурсе при указании его id в запросе;
- Проверка невозможности получения информации о пользователе или ресурсе с несуществующим id;
- Проверка возможности создания нового пользователя, изменения его данных и удаления этого созданного пользователя;
- Проверка возможности регистрации пользователя;
- Попытка регистрации с 1) отсутствующим паролем (один логин); 2) неправильным набором параметров в запросе;
- Проверка возможности авторизации существующего пользователя;
- Попытка авторизации несуществующего пользователя.

  ____
