#!/usr/bin/env python
# -*- coding: utf-8 -*-

__author__ = 'shifeifei'


def my_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError("bad data type")
    if x >= 0:
        return x
    else:
        return -x


def power(x, n):
    s = 1
    while n > 0:
        n -= 1
        s = s * x
    return s


m = power(2, 3)
print(m)

n = my_abs(-4.09)
print(n)
