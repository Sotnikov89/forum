<a href="https://codecov.io/gh/Sotnikov89/forum">
  <img src="https://codecov.io/gh/Sotnikov89/forum/branch/master/graph/badge.svg?token=KMBOWH7IHO"/>
</a>
<a href="https://travis-ci.com/github/Sotnikov89/forum">
  <img src="https://travis-ci.com/Sotnikov89/forum.svg?branch=master" />
</a>

# Цель проекта
Проект создавался для изучения работы Spring boot, H2. Также для отработки реализации Spring Security, JPA и наглядной демонстрации преимущества работы с Spring избавившись от конфигураций, настройки TomCat, упрощение работы с БД - CRUD операций.
# Описание проекта
Проект представляет собой классическое приложение — форум.
![ScreenShot](images/1.PNG)
Реализована возможность регистрации и авторизации, создание и редактирование темы. Данные хранятся в памяти, H2.
Проведено тестирование методов всех контроллеров и сервисов с помощью Spring mock.
# Запуск проекта
Для запуска достаточно определить класс LoadForH2 в пакете bootstrap в качестве @Component. Данный класс реализует ApplicationListener, и при старте приложения в БД будут загружены примеры тем, а также пользователи, логин - admin, пароль 123.
В resources вы найдете конфигурационный файл application.properties в котором, по желанию, вы можете закомментировать подключение к H2 и установить подключение к реальной БД.
При необходимости, для создания таблиц, можете воспользоваться sql скриптом в resources.db.

