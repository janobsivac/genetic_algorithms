# Genetická rekonstrukce obrázku (Java)

Tento projekt implementuje **genetický algoritmus** (GA) v jazyce Java. Cílem programu je poskládat sadu poloprůhledných polygonů tak, aby výsledný obraz co nejvíce odpovídal zadané předloze (např. fotce).

Projekt demonstruje principy evolučních algoritmů: reprezentaci problému (genotyp/fenotyp), křížení, mutaci a selekci.

## 🚀 Jak to funguje

Program simuluje biologickou evoluci:
1.  **Start:** Vytvoří populaci náhodných "čmáranic" (chromozomů).
2.  **Hodnocení (Fitness):** Každé řešení porovná pixel po pixelu s předlohou a spočítá chybu. Čím menší chyba, tím lepší jedinec.
3.  **Evoluce:**
    * **Selekce:** Vybere lepší jedince pro reprodukci (např. turnajová metoda).
    * **Křížení:** Zkombinuje vlastnosti dvou rodičů.
    * **Mutace:** Náhodně změní barvu nebo polohu polygonu, aby se zachovala diverzita.
4.  **Opakování:** Tento proces běží tisíce generací, dokud se obraz nepodobá předloze.

## 📂 Struktura projektu

* **`Main.java`**: Hlavní třída. Nastavuje parametry evoluce a spouští smyčku.
* **`Chromozome.java`**: Reprezentuje jedno řešení (sadu polygonů). Obsahuje metody pro mutaci, křížení a vykreslení.
* **`Populace.java`**: Spravuje seznam jedinců a provádí evoluční kroky (selekce, tvorba nové generace).
* **`Fitness.java`**: Načítá předlohu a počítá rozdíl (chybu) mezi vygenerovaným obrázkem a originálem.
* **`ShowChromozome.java`**: Pomocná třída pro vizualizaci nejlepšího výsledku v okně.

## 🛠️ Požadavky a instalace

* **Java JDK 8** nebo novější.
* Vývojové prostředí (IntelliJ IDEA, Eclipse, NetBeans) nebo textový editor + terminál.

### Příprava předlohy
Aby program fungoval, **musíte** mít ve složce projektu připravený obrázek:
1.  V kořenovém adresáři projektu vytvořte složku `image`.
2.  Vložte do ní svůj obrázek (nebo upravte cestu v `Main.java`).

## ▶️ Spuštění

1.  Zkompilujte a spusťte třídu `Main`.
2.  V konzoli uvidíte průběh generací a snižující se chybu (Best Fitness).
3.  Po dokončení (výchozí nastavení je 3 000 generací) se otevře okno s nejlepším nalezeným výsledkem.

## ⚙️ Konfigurace (v `Main.java`)

Parametry algoritmu můžete měnit přímo v kódu:

```java
int popSize = 50;           // Velikost populace (více = pomalejší, ale důkladnější) [cite: 1998]
double mutationRate = 0.01; // Pravděpodobnost mutace (cca 1-2%)
double crossRate = 0.5;     // Pravděpodobnost křížení
int generations = 3000;    // Počet generací
