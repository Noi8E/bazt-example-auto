# Автотесты на главную страницу [bazt.ru](https://bazt.ru/)
___
## Стэк проекта:
| Java | Selenide | Junit5 | Gradle | Selenoid | Jenkins | IntelliJ IDEA | Allure Report | Telegram |
|:------:|:----:|:------:|:------:|:--------:|:--------:|:-------------:|:---------:|:--------:|
| <img src="images/JAVA.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/IDEA.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |

___

## Автотесты запускаются через [Jenkins](https://jenkins.autotests.cloud/job/bazt-example-auto/)

## Используемые параметры по умолчанию 

* BROWSER (default chrome)
* BROWSER_VERSION (default 89.0)
* BROWSER_SIZE (default 1920x1080)
* REMOTE_DRIVER_URL (url address from selenoid or grid)
* THREADS (number of threads to run)
* ALLURE_NOTIFICATIONS_VERSION (default: 3.1.2)

## Возможна так же ручная настройка параметров [CI](https://jenkins.autotests.cloud/job/bazt-example-auto/configure) <a href="https://www.jetbrains.com/idea/"><img src="./images/Jenkins.svg" width="30" height="30"  alt="Jenkins"/></a>

![alt "Ручная настройа параметров"](media/settings.png)

### Run tests with filled local.properties:

```bash
gradle clean test
```

### Run tests with not filled local.properties:

```bash
gradle clean -DremoteDriverUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

### Serve allure report:

```bash
allure serve build/allure-results
```

## Результат прогона можно увидеть в Allure
![alt "Allure run"](media/run.png "Allure Report")
## К каждому тесту прикладываются: 
- Скриншоты 
- Исходники страницы
- Логи браузера
- Видео 

![alt "Allure steps"](media/testSteps.png "Test steps")

## Результаты прохождения отправляются ботом в телеграм <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="30" height="30"  alt="Telegram"/></a>

![alt "бот в телеграмме"](media/telegram.png "бот в телеграм")

## Пример работы теста <a href="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"  alt="Selenoid"/></a>

![alt "Video"](media/gif.gif "Video")