# Genetická rekonstrukce obrázku (Java)

Tento projekt implementuje **genetický algoritmus** (GA) v jazyce Java. Cílem programu je poskládat sadu poloprůhledných polygonů tak, aby výsledný obraz co nejvíce odpovídal zadané předloze (např. fotce).

Projekt demonstruje principy evolučních algoritmů: reprezentaci problému (genotyp/fenotyp), křížení, mutaci a selekci.

## 🚀 Jak to funguje

Program simuluje biologickou evoluci:
1.  [cite_start]**Start:** Vytvoří populaci náhodných "čmáranic" (chromozomů)[cite: 1481].
2.  **Hodnocení (Fitness):** Každé řešení porovná pixel po pixelu s předlohou a spočítá chybu. [cite_start]Čím menší chyba, tím lepší jedinec [cite: 1579-1605].
3.  **Evoluce:**
    * [cite_start]**Selekce:** Vybere lepší jedince pro reprodukci (např. turnajová metoda)[cite: 1901].
    * [cite_start]**Křížení:** Zkombinuje vlastnosti dvou rodičů[cite: 1804].
    * [cite_start]**Mutace:** Náhodně změní barvu nebo polohu polygonu, aby se zachovala diverzita[cite: 1440].
4.  [cite_start]**Opakování:** Tento proces běží tisíce generací, dokud se obraz nepodobá předloze [cite: 1972-1976].

## 📂 Struktura projektu

* **`Main.java`**: Hlavní třída. [cite_start]Nastavuje parametry evoluce a spouští smyčku[cite: 1701].
* **`Chromozome.java`**: Reprezentuje jedno řešení (sadu polygonů). [cite_start]Obsahuje metody pro mutaci, křížení a vykreslení[cite: 1523].
* [cite_start]**`Populace.java`**: Spravuje seznam jedinců a provádí evoluční kroky (selekce, tvorba nové generace)[cite: 1882].
* [cite_start]**`Fitness.java`**: Načítá předlohu a počítá rozdíl (chybu) mezi vygenerovaným obrázkem a originálem[cite: 1738].
* [cite_start]**`ShowChromozome.java`**: Pomocná třída pro vizualizaci nejlepšího výsledku v okně[cite: 1526].

## 🛠️ Požadavky a instalace

* **Java JDK 8** nebo novější.
* Vývojové prostředí (IntelliJ IDEA, Eclipse, NetBeans) nebo textový editor + terminál.

### Příprava předlohy
Aby program fungoval, **musíte** mít ve složce projektu připravený obrázek:
1.  V kořenovém adresáři projektu vytvořte složku `image`.
2.  [cite_start]Vložte do ní obrázek s názvem `orloj.jpg` (nebo upravte cestu v `Main.java`)[cite: 1738].

## ▶️ Spuštění

1.  Zkompilujte a spusťte třídu `Main`.
2.  V konzoli uvidíte průběh generací a snižující se chybu (Best Fitness).
3.  Po dokončení (výchozí nastavení je 10 000 generací) se otevře okno s nejlepším nalezeným výsledkem.

## ⚙️ Konfigurace (v `Main.java`)

Parametry algoritmu můžete měnit přímo v kódu:

```java
int popSize = 50;           // Velikost populace (více = pomalejší, ale důkladnější) [cite: 1998]
double mutationRate = 0.01; // Pravděpodobnost mutace (cca 1-2%)
double crossRate = 0.5;     // Pravděpodobnost křížení
int generations = 10000;    // Počet generací (doporučeno > 5000)
