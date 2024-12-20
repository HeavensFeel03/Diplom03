# Дипломный проект по профессии «Инженер по тестированию»: тестирование мобильного приложения «Мобильный хоспис»

- [Задание](https://github.com/netology-code/qamid-diplom)
- [План тестирования](https://github.com/HeavensFeel03/Diplom03/blob/main/docs/Plan.md)
- [Отчет о тестировании](https://github.com/HeavensFeel03/Diplom03/blob/main/docs/Result.md)
- [Результаты тестирования](https://github.com/HeavensFeel03/Diplom03/blob/main/docs/allure-results.zip)
- [Отчеты о выявленных ошибках](https://github.com/HeavensFeel03/Diplom03/issues)



## Установка и запуск авто-тестов
1. Склонировать [репозиторий](https://github.com/HeavensFeel03/Diplom03)
2. Открыть проект в Android Studio
3. Установить эмулятор Android API 29 или подключить мобильный телефон Android API 29
4. Установить на эмуляторе или мобильном телефоне в системных настройках английский язык основным
5. Открыть папку app\src\androidTest\java\ru\iteco\fmhandroid\ui\test
6. Запустить тесты:
   - нажав правую кнопку мыши из открывшегося списка выбрать команду Run All Tests
   - или ввести в терминале в корне проекта команду ./gradlew connectedAndroidTest

## Формирование отчета Allure с эмулятора
1. Открыть Device File Explorer на эмуляторе
2. Выгрузить каталог результатов тестирования расположенный на эмуляторе /data/data/ru.iteco.fmhandroid/files
3. В терминале, в директории  каталога с результатами тестирования, запустить команду allure serve
4. Дождаться генерации отчёта и посмотреть его в открывшемся окне браузера
