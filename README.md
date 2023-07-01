## *UI autotests*

**Теория к секции**

+ Java
    + [Maven](https://habrahabr.ru/post/77382/)
+ Selenium
    + [Краткий учебник по Selenium](https://kreisfahrer.gitbooks.io/selenium-webdriver/content/index.html)

#### Задача U0. Настройка окружения

*Теория к задаче:* [git](https://git-scm.com/book/ru/v2), [Java TestNG](http://testng.org/doc/documentation-main.html)
, [Maven](https://habrahabr.ru/post/77382/), [page object model](http://internetka.in.ua/selenium-page-object/)
, [Selenium](https://kreisfahrer.gitbooks.io/selenium-webdriver/content/index.html)

1. Устанавливаем **Chrome**.
2. Скачиваем и устанавливаем **IntelliJ IDEA Community Edition**
   с [оф. сайта](https://www.jetbrains.com/idea/download/#section=windows).
3. Ставим себе Java [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
   и [JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html):
    1. Скачиваем по ссылкам выше, устанавливаем из файла, запомнив директорию установки (на рисунке выделена красным)
       ![РИСУНОК](http://java-course.ru/first/images/jdkInstall_02.png)
    2. Создаем новую переменную окружения `JAVA_HOME`, которая смотрит на эту директорию
    3. В PATH дописать `;%JAVA_HOME%\bin`
    4. Создаем еще одну переменную окружения `JAVA` и помещаем в нее `%JAVA_HOME%\bin`
4. Установка [Maven](http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip)
    1. Скачиваем по ссылке выше, распаковываем в `C:\Program Files\Maven`
    2. Добавляем новую переменную окружения `MAVEN_HOME`, которая смотрит на папку, куда мы его распаковали.
    3. В `PATH` добавляем `;%MAVEN_HOME%\bin`
    4. Стартуем новую консоль и проверяем работоспособность Maven командой `mvn -version`  Если у вас всё получилось, то
       вы увидите вот такой результат:
       ![РИСУНОК](https://1.bp.blogspot.com/-Y-Q7Ufpu_gM/Wrhee8i85kI/AAAAAAAAFLY/jIn774dcYBcBrA5Ks4BtI4_ddvTffNJAQCEwYBhgL/s1600/Test%2BMaven.png)
5. Скачиваем chromedriver [отсюда](http://chromedriver.chromium.org/downloads)
    1. создаем у себя папку `C:\webdrivers`
    2. кладем скачанный chromedriver в эту папку
    3. в переменную окружения `PATH` добавляем `;C:\webdrivers`
6. Скачиваем и устанавливаем [Git](https://git-scm.com/download/win)
    1. На последнем экране установки ставим галочку в чекбокс “запустить git bash”
    2. В открывшемся окне консоли производим начальную настройку git:

```
git config --global user.name "ИМЯ_ФАМИЛИЯ_ЛАТИНИЦЕЙ"
git config --global user.email ЕМЕЙЛ
```

3. Если не хочется связываться с vim, то можно указать другой редактор, например:

```
git config --global core.editor notepad
```

4. Сгенерировать ssh-ключ
   по [инструкции](https://git-scm.com/book/ru/v2/Git-%D0%BD%D0%B0-%D1%81%D0%B5%D1%80%D0%B2%D0%B5%D1%80%D0%B5-%D0%93%D0%B5%D0%BD%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8F-%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D0%BE%D0%B3%D0%BE-SSH-%D0%BA%D0%BB%D1%8E%D1%87%D0%B0#_generate_ssh_key)
5. Задание по данному блоку и последующим следует выполнять следующим образом:
   1. Создаете репозиторий в любом бесплатном сервисе для Git-репозиториев (Gitlab, Github и т.д.) и создаете там главную ветку (main или master);
   2. Клонируете его к себе и создаете новую ветку, где и ведете разработку;
   3. Когда работа готова, пушите свои правки на удаленный репозиторий; 
   4. Потом создаете Merge Request/Pull Request своей ветки в главную;
   5. Отправляете ссылку на MR/PR своему ментору;

#### Задача U1. Создание проекта с автотестами с нуля

*Теория к задаче:* [git](https://git-scm.com/book/ru/v2), [Java TestNG](http://testng.org/doc/documentation-main.html)
, [Maven](https://habrahabr.ru/post/77382/), [page object model](http://internetka.in.ua/selenium-page-object/)
, [Selenium](https://kreisfahrer.gitbooks.io/selenium-webdriver/content/index.html)

1. Получить от ментора один или более тест-кейсов для автоматизации.
2. Создать собственный проект автотестов для [way2automation](http://way2automation.com) с правильной структурой.
   использованием TestNG, паттернов (POM, Factory).
    1. Подробную инструкцию по созданию проекта в IntelliJ IDEA,
       смотрим [здесь](http://info.javarush.ru/idea_help/2013/07/31/%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-%D0%BF%D0%B5%D1%80%D0%B2%D0%BE%D0%B3%D0%BE-Java-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D1%87%D0%B0%D1%81%D1%82%D1%8C-1-.html)
       и [здесь](http://info.javarush.ru/idea_help/2013/07/31/%D0%A1%D0%BE%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5-%D0%B8-%D0%B7%D0%B0%D0%BF%D1%83%D1%81%D0%BA-%D0%BF%D0%B5%D1%80%D0%B2%D0%BE%D0%B3%D0%BE-Java-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D1%87%D0%B0%D1%81%D1%82%D1%8C-2-.html)

Примечание:
соблюдать [Java Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf) ([на русском](https://www.magnumblog.space/java/131-translating-java-code-conventions))

#### Задача U2. Allure

*Теория к задаче:* [Allure](https://docs.qameta.io/allure/)
, [Серьезность и Приоритет Дефекта](http://www.protesting.ru/testing/bugpriority.html)

1. Добавить в проект отчеты Allure.
2. Добавить аннотацию Severity к каждому тест кейсу
3. Добавить аннотацию Step к каждому публичному методу всех Page Object
4. Добавить аннотации Epic, Feature, Story

#### Задача U3. DataProvider

*Теория к задаче:* [DataProvider](http://testng.org/doc/documentation-main.html#parameters-dataproviders)

1. Сделать новый test suite
2. Разработать универсальный тест кейс, использующий разные данные для авторизации (в том числе и некорректные)
3. В качестве источника разных параметров использовать возможность TestNG `DataProvider`

#### Задача U4. Screenshots

*Теория к задаче:* [aShot](https://github.com/yandex-qatools/ashot)

В проекте с Allure добавить поддержку скриншотов, делать скриншот при падении теста. Специально добавить несколько
падающих кейсов для демонстрации фичи в отчете Allure.

#### Задача U5. Cookies

1. Написать функцию записи куков в файл и считывания куков из него.
2. Написать тест, авторизующийся при первом запуске и использующий куки при втором (куки брать из предыдущего прогона)
3. Залить в проект

Примечание:  [ссылку на форму авторизации c рабочими куками рекомендуется взять из сайта с упражнениями sql](https://www.sql-ex.ru/)

#### Задача U6. JavaScriptExecutor

1. С помощью JavaScriptExecutor убрать фокус из поля ввода
2. С помощью JavaScriptExecutor определить наличие скролла на странице
3. Вынести код JavaScriptExecutor в отдельные функции, пометить каждую как Step
4. Реализовать тест-кейс, использующий описанный функционал, залить в проект

#### Задача U7. Параллельный запуск тестов

*Теория к задаче:*
[статья об организации параллельного Selenium тестирования](http://www.deepshiftlabs.com/sel_blog/?p=1932&lang=ru),
[настройка Selenium Grid](https://comaqa.gitbooks.io/selenium-webdriver-lectures/content/selenium_grid_i_headless_brauzeri/grid_nastroika_i_isrolzovanie.html)
,
[ипользование Selenium Grid в коде](https://www.browserstack.com/guide/selenium-grid-tutorial),
[о Selenoid](https://www.pawangaria.com/post/docker/selenoid-as-alternative-selenium-grid-with-docker/)

1. Написать отдельную testng.xml конфигурацию для многопоточного запуска тестов (минимум два потока, каждый suite в
   своём потоке)
2. Написать bat и sh скрипты для развертывания Selenium GRID (hub и node), позволяющий прогнать автотесты в нужном количестве потоков
3. Залить всё необходимое для многопоточного запуска в проект

#### Задача U8. Перезапуск упавших тестов

1. Настроить автоматический повторный запуск упавших кейсов, указать 2 попытки перезапуска
2. Написать скрипт, для выполнения только упавших кейсов с предыдущего прогона
3. Залить обе наработки в проект

#### Задача U9. Браузеры

1. Настроить запуск автотестов на разных браузерах, без GRID:
    + Chrome
    + FireFox
    + Edge
    + IE (обеспечить запуск без правок в реестре, использовать capability)
    + Opera
    + Safari (опционально)
2. Настроить запуск автотестов на разных браузерах, с использованием GRID
3. Разработать класс DriverFactory, создающий различные WebDriver в зависимости от входных параметров (любые браузеры, с
   GRID и без него)
4. Залить наработки и всё необходимое для запуска на перечисленных браузерах в проект (предусмотреть драйвера для
   Windows)

#### Задача U10. Drag n Drop (IFrame)

1. Открыть http://way2automation.com/way2auto_jquery/droppable.php
2. Перетащить элемент в принимающий
3. Убедиться, что текст принимающего элемента изменился
4. Залить кейс в проект

#### Задача U11. Tabs

*Теория к задаче:* [Вкладки и окна](http://automated-testing.info/t/webdriver-features-robota-s-neskolkimi-oknami-vkladkami-odnovremenno-pri-pomoshhi-selenium-web-driver/2289)

1. Открыть http://way2automation.com/way2auto_jquery/frames-and-windows.php
2. Нажать на ссылку
3. Перенести фокус на новую вкладку, нажать ссылку
4. Убедиться, что открылась третья вкладка
5. Залить кейс в проект

#### Задача U12. Alerts

1. Открыть http://way2automation.com/way2auto_jquery/alert.php
2. Нажать Input Alert
3. Нажать кнопку, ввести кастомный текст, подтвердить
4. Убедиться, что текст применился
5. Залить кейс в проект

#### Задача U13. Basic auth

1. Открыть https://www.httpwatch.com/httpgallery/authentication/#showExample10
2. Нажать на кнопку "Display Image"
3. Пройти авторизацию (логин "httpwatch" пароль "httpwatch")
4. Убедиться, что авторизация прошла успешно
5. Залить кейс в проект

#### Задача U14. BDD практики в тестировании (дополнительно).

*Теория к задаче:* [статья на habr](https://habr.com/ru/post/332754/)
, [статья на habr (2)](https://habr.com/ru/post/422651/)
, [документация, гайды про cucumber, bdd и не только](https://cucumber.io/docs/cucumber/)
, [BDD wiki](https://en.wikipedia.org/wiki/Behavior-driven_development)
, [инструменты для BDD подхода](https://www.softwaretestinghelp.com/behavior-driven-development-bdd-tools/)
, [пример cucumber + spring](http://automation-remarks.com/cucumber/)
, [еще один пример реализации структуры проекта](https://www.dokwork.ru/2015/08/cucumber.html)
, [gherkin](https://wellbehaved.readthedocs.io/Gherkin.html)
, [фреймворк от бывших разработчиков сбертеха](https://github.com/sbtqa/page-factory-2)
, [allure](https://docs.qameta.io/allure/#_cucumber_jvm)

1. Необходимо реализовать с BDD подходом кейсы из вашего проекта (все или по выбору ментора). С помощью
   feature файлов описать кейсы.
