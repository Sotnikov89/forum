<a href="https://codecov.io/gh/Sotnikov89/forum">
  <img src="https://codecov.io/gh/Sotnikov89/forum/branch/master/graph/badge.svg?token=KMBOWH7IHO"/>
</a>
<a href="https://travis-ci.com/github/Sotnikov89/forum">
  <img src="https://travis-ci.com/Sotnikov89/forum.svg?branch=master" />
</a>

# Цель проекта
Проект создавался для изучения работы Spring boot, H2. Также для отработки реализации Spring Security, JPA, наглядной демонстрации преимущества работы с Spring избавившись от конфигураций, настройки TomCat, упрощение работы с БД - CRUD операциях.
# Описание проекта
Проект представляет собой классическое приложение — форум.
![ScreenShot](images/1.PNG)
Реализована возможность регистрации и авторизации, создание и редактирование темы. Данный хранятся в памяти, H2.
![ScreenShot](images/2.png)
Проведено тестирование методов всех контроллеров и сервисов.
# Запуск проекта
Проект запускается из коробки, при помощи liquibase на h2. 
При старте приложения в БД будут загружены тестовые темы, а также пользователи, логин - admin, пароль 123.
В resources вы найдете конфигурационный файл application.properties в котором по желанию вы можете закоментировать подключение к H2 и установить подключение к реальной БД.
Для запуска достаточно определить класс LoadForH2 в пакете bootstrap в качестве @Component.
В качестве альтернативы, можно запустить проект на лисенере, достаточно определить класс LoadForH2 в пакете bootstrap в качестве @Component и отключить bean liquibase.

