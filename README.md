1) Вопросы для самоконтроля:

   Что означает аннотация Before?

       означет, что метод будет выполнен перед каждым тестом<
   
   Как в тесте проверить, что метод должен бросить исключение?

       Assertions.assertThrows или Assertions.assertThrowsExactly
   
   Что такое mock?
   
       метод, создающий объект-заглушку для интрефейса(класс), у которого можно задать поведение

   Spy?
   
       метод, создающий объект-обертку для объекта, который позволяет подменять поведение
   
   Для чего применяется статический метод Mockito.verify?

       позволяет проверить какие методы, сколько раз, в каком порядке и с какими параметрами были выполнены методы у моков
   
2) Реализуйте свой итератор массива объектов. Напишите тесты для проверки его работоспособности. Оформите сборку кода через maven.

3) Спроектировать дизайн соц. сети. В данном задании интересует разбитие приложения на модули, взаимодействие интерфейсов, а не реализация конкретных классов.

   Соц. сети обычно предлагают большой набор сервисов: поиск/добавление друзей, просмотр профилей,  загрузка и просмотр фото, общение через чат или стены, рекомендации, подарки и куча других сервисов. Все эти сервисы должны находится в отдельных модулях и иметь связи между собой.
   Ваша задача создать maven проект, создать модули для каждого сервиса, прописать зависимости одних модулей от других. В каждом модуле должны быть интерфейсы и доменная модель данного сервиса + в некоторых модулях нужна примерная реализация интерфейсов, где показано как используются интерфейсы других модулей.
   Написать юнит тесты к классам из данного задания (с помощью junit5 + mockito)
