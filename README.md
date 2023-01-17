## Сортировка слиянием нескольких файлов

### Параметры программы задаются при запуске через аргументы командной строки:

1. режим сортировки (`-a` или `-d`), необязательный, по умолчанию сортируем по возрастанию;
2. тип данных (`-s` или `-i`), обязательный;
3. имя выходного файла, обязательное;
4. остальные параметры – имена входных файлов, не менее одного.

Примеры запуска из командной строки для Windows (для приложенного файла):

* `java -jar sort_task.jar -i -a out.txt in.txt` (для целых чисел по возрастанию)
* `java -jar sort_task.jar -s out.txt in1.txt in2.txt in3.txt` (для строк по возрастанию)
* `java -jar sort_task.jar -d -s out.txt in1.txt in2.txt` (для строк по убыванию)

Стек Технологий

* `Java SE 16`
* `Maven 4.0.0`

Контактные данные разработчика

* `m-or-ev@yandex.ru`
* ` 89538614597 - Марк`

