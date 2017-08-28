(ns q-021.core-test
  (:require [clojure.test :refer :all]
            [q-021.core :refer :all]))

(deftest q-021-test
  (is (= (-main) 31626)))
