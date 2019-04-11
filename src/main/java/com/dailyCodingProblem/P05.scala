// This problem was asked by Jane Street.

// cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

// Given this implementation of cons:

// def cons(a, b):
//     def pair(f):
//         return f(a, b)
//     return pair
// Implement car and cdr.
def cons[A, B, C](a: A, b: B): ((A, B) => C) => C = {
  def pair(f: (A, B) => C): C = f(a, b)

  pair _
}

def car[A, B](pair: ((A, B) => A) => A): A = {
  def first[A, B](a: A, b: B): A = a

  pair(first)
}

def cdr[A, B](pair: ((A, B) => B) => B): B = {
  def second[A, B](a: A, b: B): B = b

  pair(second)
}