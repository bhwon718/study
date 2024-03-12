# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.
import datetime
import os
import random
import sys
import time
import urllib.request


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press ⌘F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    # print_hi('PyCharm')

    # dist = {"name": "이름", 'type': "유형"};
    # print(dist)
    #
    # dist['add'] = "추가"
    #
    # print(dist)
    #
    # if 'add' in dist:
    #     print(dist['add'])
    #     print(dist.get('add'))
    # else:
    #     print('존재하지 않는키')
    #
    # del dist['add']
    # print(dist)
    #
    # if 'add' in dist:
    #     print(dist['add'])
    # else:
    #     print('존재하지 않는키')
    #
    #
    # for key in dist:
    #     print(dist.get(key))

    #
    #     print(range(5))
    #
    #     print(list(range(0,5)))
    #
    #     print(list(range(1,11)))
    # # See PyCharm help at https://www.jetbrains.com/help/pycharm/
    #
    #
    #
    #     print(list(range(10,0, -1)))
    #
    #     for i in reversed(range(1,5+1)):
    #         print("i : {}".format(i))

    # output = "";
    # for i in range(10):
    #
    #
    #     output +=("*"*i)+"\n";
    #
    #
    #
    # print(output)

    # print();

    #
    # while int(time.time()) <=1710220000 :
    #     time.sleep(1)
    #     print("now : ",time.time())

    # while True :
    #     time.sleep(0.1);
    #     print("# ",end="")

    # number = 0;
    #
    # target_tick = time.time() + 5;
    # while time.time() < target_tick:
    #     number+=1
    #
    # print(number);

    # numbers = [1902, 123, 124, 124, 36346, 234];
    #
    # print("max : ", max(numbers));
    # print("min : ", min(numbers));
    # print("sum : ", sum(numbers));

    # example_list = ["요소A", "요소B", "요소C"];
    #
    # for i, value in enumerate(example_list):
    #     print("i:", i);
    #     print("value : ", value)

    # example_dictionary = {
    #     "키A": "값A",
    #     "키B": "값B",
    #     "키C": "값C"
    # }
    #
    # print(example_dictionary)
    #
    # print(example_dictionary.items())
    #
    # array = [i * i for i in range(0, 20, 2)]
    # print(array)

    # power = lambda x: x*x
    #
    # list_input = list(range(1,6))
    #
    #
    # print(list(map(power,list_input)))
    #
    # print(list(filter(lambda x:x<3, list_input)))

    # file = open("basic.txt","w");
    # # file.write("Hello Python Programing....");
    # file.write("#####")
    # file.close()

    # with open("basic.txt","w") as file:
    #     file.write("new");
    #
    # with open("basic.txt","r") as file:
    #     print(file.read());
    #
    #

    # print(sys.argv)

    # print(sys.version_info)

    # print(os.system("cd ~/ ))

    # for i in range(1000):
    #     print(datetime.datetime.now().second)
    #     time.sleep(1);

    class Student:
        def __init__(self, name, korean, math, english, science):
            self.name = name;
            self.korean = korean;
            self.math = math;
            self.english = english;
            self.science = science
            print("생성자 : {}".format(self.name))

        def __str__(self):
            return "str?";

        def __del__(self):
            print("소멸자 : {}".format(self.name))

        def __lt__(self, other):
            return True;

        # @classmethod
        def to_string(self):
            return "이름 : {}" \
                   "\n-국어 : {}" \
                   "\n-수학 : {}" \
                   "\n-영어 : {}" \
                   "\n-과학 : {}" \
                .format(self.name, self.korean, self.math, self.english, self.science)


    students = [
        Student("원채은", 100, 100, 100, 100)


    ]

    for v in students:
        # print(v.to_string())
        print(str(v))
