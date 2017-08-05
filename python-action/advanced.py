#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'shifeifei'

data = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
# 记住倒数第一个元素的索引是-1
n = data[0:3]
print(n)

# 取列表后三个元素
n = data[-3:]
print(n)

# 复制
n = data[:]
print(n)


# 元组也是一种list,区别是元组内容不可变
m = (0, 1, 2, 3, 4, 5, 6)
k = m[0:2]
print(k)


# 迭代字典
d = {"a": 1, "b": 2, "c": 3, "d": 4, "e": 5}
for key in d:
    print(key)

for k, v in d.items():
    print("%s--%d" % (k, v))

# 同时索引列表下标和元素
L = ["a", "b", "c", "d", "e"]
for i, v in enumerate(L):
    print(i, v)

# 同时遍历
for x, y in [(1, 1), (2, 4), (3, 9)]:
    print(x, y)

