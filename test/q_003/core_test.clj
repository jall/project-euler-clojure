(ns q-003.core-test
  (:require [clojure.test :refer :all]
            [q-003.core :refer :all]))

(deftest q-003-test
  (is (= (-main) 6857)))
