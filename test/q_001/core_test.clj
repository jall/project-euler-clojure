(ns q-001.core-test
  (:require [clojure.test :refer :all]
            [q-001.core :refer :all]))

(deftest q-001-test
  (testing "Question 1 is correct"
    (is (= (-main) 233168))))
