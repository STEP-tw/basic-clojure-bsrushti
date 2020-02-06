(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-truthy-value
  (testing "truthy value (2)"
    (is (= 2 (harishchandra 2))))
  (testing "truthy value ([])"
    (is (= [] (harishchandra []))))
  (testing "truthy value (\"\")"
    (is (= "" (harishchandra ""))))
  (testing "falsy value (nil)"
    (is (= nil (harishchandra nil))))
  (testing "falsy value (false)"
    (is (= nil (harishchandra false)))))

(deftest yudishtira-truthy-value
  (testing "truthy value (2)"
    (is (= 2 (yudishtira 2))))
  (testing "truthy value ([])"
    (is (= [] (yudishtira []))))
  (testing "truthy value (\"\")"
    (is (= "" (yudishtira ""))))
  (testing "falsy value (nil)"
    (is (= :ashwathama (yudishtira nil))))
  (testing "falsy value (false)"
    (is (= :ashwathama (yudishtira false)))))

(deftest duplicate-first-test
  (testing "non empty coll"
    (is (= [1 1 2] (duplicate-first [1 2]))))
  (testing "empty coll"
    (is (= nil (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "return :chetan-bhagat"
    (is (= :chetan-bhagat (five-point-someone 4 5))))
  (testing "return :satan-bhagat"
    (is (= :satan-bhagat (five-point-someone 5 9))))
  (testing "return :greece"
    (is (= :greece (five-point-someone 6 4))))
  (testing "return :universe"
    (is (= :universe (five-point-someone 8 8)))))

(deftest repeat-and-truncate-test
  (testing "with rep true and truncate true take 6"
    (is (= '(0 1 2 3 0 1) (repeat-and-truncate (range 4) true true 6))))
  (testing "with rep false truncate true 3"
    (is (= '(0 1 2) (repeat-and-truncate (range 4) false true 3))))
  (testing "with rep true truncate false 3"
    (is (= '(0 1 0 1) (repeat-and-truncate (range 2) true false 3))))
  (testing "with rep false truncate false 3"
    (is (= '(0 1) (repeat-and-truncate (range 2) false false 3)))))


(deftest order-in-words-test
  (testing "x > y and y > z and z > x"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "x > y and z > x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 8))))
  (testing "z > x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 8)))))

(deftest zero-aliases-test
  (testing "return :zero"
    (is (= :zero (zero-aliases 0))))
  (testing "return :empty"
    (is (= :empty (zero-aliases []))))
  (testing "return :empty"
    (is (= :empty (zero-aliases ()))))
  (testing "return :empty-set"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "return :empty-map"
    (is (= :empty-map (zero-aliases {}))))
  (testing "return :empty-string"
    (is (= :empty-string (zero-aliases ""))))
  (testing "return default :not-zero"
    (is (= :not-zero (zero-aliases 123))))
  )

(deftest zero-separated-palindrome-test
  (testing "return (4 3 2 0 2 3 4)"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
  (testing "return (2 3 4 0 4 3 2)"
    (is (= '(2 3 4 0 4 3 2) (zero-separated-palindrome [3 2 1])))))
