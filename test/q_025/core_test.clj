(ns q-025.core-test
  (:require [clojure.test :refer :all]
            [q-025.core :refer :all]))

(deftest q-025-test
  (is (= (-main) 4782)))
