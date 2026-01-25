(ns third.core
  (:gen-class))

(defn my-seq []
  (println (seq ' (1 2 3)))
  (println(seq [1 2 3]))
  (println(seq #{1 2 3}))
  (def lv (seq {:name "Bill Compton" :occupation "Dead mopey guy"})); the result: list of vectors
  (println lv)
  (println (into {} lv)); from list of vectors to map
  (list)
  (set)
  )

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [avg sum count])
  )

(defn my-take-while []
  (def food-journal
    [{:month 1 :day 1 :human 5.3 :critter 2.3}
     {:month 1 :day 2 :human 5.1 :critter 2.0}
     {:month 2 :day 1 :human 4.9 :critter 2.1}
     {:month 2 :day 2 :human 5.0 :critter 2.5}
     {:month 3 :day 1 :human 4.2 :critter 3.3}
     {:month 3 :day 2 :human 4.0 :critter 3.8}
     {:month 4 :day 1 :human 3.7 :critter 3.9}
     {:month 4 :day 2 :human 3.7 :critter 3.6}])

;  it can be '% :month' or ':month %'
  (take-while #(< (% :month) 3) food-journal)
  (drop-while #(< (:month %) 3) food-journal)

;  cam we be used together
  (take-while #(< (% :month) 3)
              (drop-while #(< (:month %) 3) food-journal))

;  filtering only
  (filter #(< (:month %) 3) food-journal)

;  return true or nil
  (some #(> (:critter %) 3) food-journal)

;  normal sort
  (sort [3 1 2])

; sort by function (pre defined
  (sort-by count ["aaa" "c" "bb"])
  (sort-by #(- %) [1 2 3 4])

;
  (concat [1 2] [3 4])


  )

(defn my-mapper[num]
  (Thread/sleep 1000)
  (* num 10)
  )


(defn my-lazy-test[]
  (def lazy-list (map my-mapper (range 0 100))))

; now we can use (take 10 (even-numbers))
(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(defn my-apply []

  ; we will have the max here
  (max 1 2 3 4)

  ; now we can use our sequence using apply
  (apply max [1 2 3 4])

  )

; condp is like switch statement
(defn lousy-logger [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)
    )
  ; another way to use condp
;  (defn size-category [x]
;    (condp < x
;      10 "small"
;      100 "medium"
;      "large"))

  )

; partial can take some of the arguments
; so the rest of arguments can be handled later
(defn using-lousy-logger[]
  (def warn-log (partial lousy-logger :warn))
  (warn-log "nice")

  )
; there is two way to get the complement of the filter function
;(defn identify-humans
;[social-security-numbers]
;(filter #(not (vampire? %))
;        (map vampire-related-details social-security-numbers)))
;
;(def not-vampire? (complement vampire?))
;(defn identify-humans
;  [social-security-numbers]
;  (filter not-vampire?
;          (map vampire-related-details social-security-numbers)))


(defn -main
  [& args]
  (let [y (assoc {:my-key1 1})] y)
  )
