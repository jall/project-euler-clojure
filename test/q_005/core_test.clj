(ns q-005.core-test
  (:require [clojure.test :refer :all]
            [q-005.core :refer :all]))

(deftest q-005-test
    (is (= (-main) 232792560)))
