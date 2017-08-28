(ns q-022.core-test
  (:require [clojure.test :refer :all]
            [q-022.core :refer :all]))

(deftest q-022-test
  (is (= (-main) 871198282)))
