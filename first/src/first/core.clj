(ns first.core
  (:require [clojure.string :as clstr])
  (:gen-class))

(defn strings []
  (def str1 "testing besting fixing")
  (println (clstr/blank? str1))

  (def strls (clstr/split str1 #" "))
  (println strls)
  (println (clstr/join " " strls))
  (println)
  )

(defn lists []
  (def allList (list 1 2 "nice" true))
  (println allList)
  (println (first allList))
  (println (rest allList))
  (println(nth allList 2))
  (println(list* "new list" allList))
  (println(list* allList "new list" ))
  (println(cons "left add" allList))
  (println)
  )

(defn sets[]
  (def allSet (set [1 1 2 2 3 'a' 'b' 'a']))
  (println allSet)
  (println (get allSet 'a'))
  (println (contains? allSet 'a'))
  (println (conj allSet 'c'))
  (println (disj allSet 'a'))
  (println)
  )

(defn vectors[]
  (def allVector (vector 1 2 3 1 "test"))
  (println allVector)
  (println (get allVector 2))
  (println (conj allVector 'c'))
  (println (pop allVector))
  (println (subvec allVector 0 3))
  (println)
  )

(defn maps[]
  (def allMaps (hash-map "name" "suhib" "age" 23))
  (println allMaps)
  (println (get allMaps "name"))
  (println (find allMaps "name"))
  (println (contains? allMaps "name"))
  (println (keys allMaps))
  (println (vals allMaps))




  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (strings)
  (lists)
  (sets)
  (vectors)
  (maps)

  )
