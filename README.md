# burlington-hydro-calculator

Develop
-------

1. Install VSCode + Calva
1. Add [NRepl Piggieback](https://github.com/nrepl/piggieback) to your dev environment
1. Run Calva: Jack-in and select the "deps.edn + ClojureScript built-in for browser" project type.
1. Access the website via http://localhost:9000

Or, simply run:

```bash
clj -M -m cljs.main -d "out" -c burlington-hydro-calculator.static-website -r
```

Compile
-------
```bash
clj -M -m cljs.main -d "out" -c burlington-hydro-calculator.static-website -O advanced
```