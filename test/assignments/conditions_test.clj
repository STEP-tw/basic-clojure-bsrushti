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
