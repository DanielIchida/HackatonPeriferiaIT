<h2>Nivel 1</h2>
<p>Estrategia para el algoritmo</p>
<p>1. Identifico las diferentes formas de encontrar los patrones en este criterio de busqueda encontre 8 formas</p>
<ul>
  <li>Horizontal de Derecha a Izquierda</li>
  <li>Horizontal de Izquierda a Derecha</li>
  <li>Vertical de Arriba hacia Abajo</li>
  <li>Vertical de Arriba hacia Arriba</li>
  <li>Diagonal Superior de Derecha a Izquierda</li>
  <li>Diagonal Superior de Izquierda a Derecha</li>
  <li>Diagonal Inferior de Derecha a Izquierda</li>
  <li>Diagonal Inferior de Izquierda a Derecha</li>
</ul>
<p>2. Identifico que sean 4 letras seguidas por cada criterio de busqueda</p>
<p>3. Sumo todas las posibilidades que se encontraron</p>
<p>4. Y si encuentra mas de 1 quiere decir que le dna es mutante</p>
<p>5. Y si encuentra mas de 1 quiere decir que le dna es mutante</p>
<h2>Nivel 2</h2>
<p>(POST )https://mutantsdna.azurewebsites.net/adn/mutant</p>
<P>(Request) {"dna" : ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}</P>
<p>(Response) {
    "message": "OK",
    "error": "",
    "data": {
        "mutant": true
    }
}</p>
<h2>Nivel 3</h2>
<p>(GET) https://mutantsdna.azurewebsites.net/adn/stats</p>
<p>(Response) {
    "message": "OK",
    "error": "",
    "data": {
        "countMutantDna": 1,
        "countHumanDna": 2,
        "ratio": 0.5
    }
}</p>
<p>Servicio publicado en Azure</p>
<p>Se utiliza base de datos H2</p>
<p>Test Sonar</p>
<p>Se alcanzo un coverage del (86%)</p>

![Sonar Qube](https://raw.githubusercontent.com/DanielIchida/HackatonPeriferiaIT/master/Sonar.png)

<p><b>MutantsApi.postman_collection.json</b> Archivo postman para importar endpoints</p>