import math

def circle_area(radius):
    return round(math.pi * radius ** 2, 2)

def rectangle_area(width, height):
    return width * height

def factorial(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
