(ns q-010.core-test
  (:require [clojure.test :refer :all]
            [q-010.core :refer :all]))

(deftest q-010-test
  (is (= (-main) 142913828922)))
