# testFileSortingMerge
Для сборки проекта используется:
- Java 11
- Gradle v7.6

Проект разрабытывался в Linux Ubuntu 22.04. Все дальнейшие команды не тестировались на других ОС.

## Сборка приложения
Откройте в терминате корневую директорию проекта и выполните команду:
> cd </path/to/project/>

> ./gradlew clean build

## Запуск приложения
Для запуска приложения необходимо заранее подготовить файлы, которые планируется 
отсортировать. Данные внутри файлов должны быть отсортированы в необходимом порядке.
Если данные в исходных файлах не будут отсортированы, то элементы, нарушающие порядок
сортировки будут восприняты системой как "неправильные" и проигнорированы.

Также все элементы файлов должны соответствовать типу обрабатываемых данных. Если
приложению не удается преобразовать элемент файла к типу, то данные считаются некорректными и игнорируются.
В строковом типе данных пробельные символы недопустимы.

По умолчанию файлы размещаются в рабочей директории. 
Для изменения пути расположения файлов необходимо указать переменную окружения:
> export WORK_DIRECTORY=</директория/размещения/файлов>

Выходной файл также будет размещен в той же директории, где хранятся входные

Для запуска приложения введите следующию команду в терминал:
> cd /path/to/project/

> java -jar build/libs/testFileMergeSort-1.0.jar [-d|-a] <-c|-i> <out> <in1, in2, ...>

## Описание входных параметров
1. Порядок сортировки(необязательный):<br>
По умолчанию прямой порядок сортировки. Обязательно указывается первым параметром.<br>
Доступны 2 значения (-d - обратный, -a - прямой).

2. Тип данных(обязательный):<br>
Может быть указан первым параметром (при отсутствии порядка сортировки) либо вторым<br>
Доступно 2 значения (-s - строковый, -i - целые числа)
3. Имя выходного файла(обязательное):<br>
Указывается после предыдущих параметров
4. Список имен входных файлов(обязательный):<br>
Указываются все входные файлы через пробел






