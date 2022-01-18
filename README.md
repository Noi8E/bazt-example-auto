# Автотесты на главную страницу [bazt.ru](https://bazt.ru/)
___
## Стэк проекта:
| Java | Selenide | Junit5 | Gradle | Selenoid | Jenkins | IntelliJ IDEA | Allure Report | Telegram |
|:------:|:----:|:------:|:------:|:--------:|:--------:|:-------------:|:---------:|:--------:|
| <img src="media/images/JAVA.svg" width="40" height="40"> | <img src="media/images/Selenide.svg" width="40" height="40"> | <img src="media/images/Gradle.svg" width="40" height="40"> | <img src="media/images/Junit5.svg" width="40" height="40"> | <img src="media/images/Selenoid.svg" width="40" height="40"> | <img src="media/images/Jenkins.svg" width="40" height="40"> | <img src="media/images/IDEA.svg" width="40" height="40"> | <img src="media/images/Allure Report.svg" width="40" height="40"> | <img src="media/images/Telegram.svg" width="40" height="40"> |

___

## Автотесты запускаются через [Jenkins](https://jenkins.autotests.cloud/job/bazt-example-auto/)

## Используемые параметры по умолчанию 

* BROWSER (default: chrome)
* BROWSER_VERSION (default: 89.0)
* BROWSER_SIZE (default: 1920x1080)
* REMOTE_DRIVER_URL (url address from selenoid or grid)
* THREADS (default: 5)
* ALLURE_NOTIFICATIONS_VERSION (default: 3.1.2)
___

## Возможна так же ручная настройка параметров [Jenkins](https://jenkins.autotests.cloud/job/bazt-example-auto/configure) <img src="media/images/Jenkins.svg" width="40" height="40">


### Запуск тестов с файлом конфигурации .properties:

```bash
gradle clean test
```

### Запуск тестов без файла конфигурации:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Генерация и просмотр отчета:

```bash
allure serve build/allure-results
```
___

## Проверяемый функционал
* Тест страницы с Контактами
* Тест главной Страницы
* Тест страницы поиска по сайту
* Тест карусели на главной странице
___

## Результат прохождения тестов / лаунчей можно импортировать в Jira-таски
![alt "Jira issue"](media/images/Jira.png "Jira task")

## Результат прохождения тестов генереируется в Allure-report
![alt "Allure run"](media/images/allureReport.png "Allure Report")

## В качестве системы управления Тестами используется Allure-TestOps
![alt "Allure TestOps"](media/images/TestOps.png "Allure TestOps")


## К каждому тесту прикладываются: 
- Скриншоты 
- Исходники страницы
- Логи браузера
- Видео 


![alt "Allure steps"](media/images/testStepsAllure.png "Test steps")

## Результаты прохождения отправляются ботом в телеграм <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

![alt "бот в телеграмме"](media/images/telegramReport.png "Telegram Bot Report")

## Пример работы теста <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video"](media/gif/attachVideo.gif "Video")