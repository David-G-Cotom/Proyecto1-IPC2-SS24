<%-- 
    Document   : creacion-revista
    Created on : 5/09/2024, 23:18:30
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Nueva Revista</title>
        <link rel="stylesheet" href="style-nueva-editar-revista.css">
    </head>
    <body>
        <div class="form-container">
            <h1>Nueva Revista</h1>
            <form method="POST" action="">
                <div class="input-group">
                    <label for="nombreRevista">Nombre de la Revista:</label>
                    <input type="text" id="nombreRevista" name="nombre"/>
                </div>
                <div class="input-group">
                    <label for="descripcionRevista">Descripcion de la Revista:</label>
                    <textarea id="descripcionRevista" name="descripcion"></textarea>
                </div>
                <div class="input-group">
                    <label for="fecha">Fecha de Creacion:</label>
                    <input type="date" id="fecha" name="fecha"/>
                </div>
                <div class="input-group">
                    <label for="categoria">Categoria:</label>
                    <select id="categoria" name="categoria">
                        <option value="SOFTWARE">SOFTWARE</option>
                        <option value="IA">IA</option>
                        <option value="TENDENCIAS DE MODA">TENDENCIAS DE MODA</option>
                        <option value="BELLEZA">BELLEZA</option>
                        <option value="ACCESORIOS">ACCESORIOS</option>
                        <option value="NUTRICION">NUTRICION</option>
                        <option value="EJERCICIO">EJERCICIO</option>
                        <option value="SALUD MENTAL">SALUD MENTAL</option>
                        <option value="MEDICINA ALTERNATIVA">MEDICINA ALTERNATIVA</option>
                        <option value="PINTURA">PINTURA</option>
                        <option value="ESCULTURA">ESCULTURA</option>
                        <option value="LITERATURA">LITERATURA</option>
                        <option value="CINE">CINE</option>
                        <option value="DESTINOS TURISTICOS">DESTINOS TURISTICOS</option>
                        <option value="GUIAS DE VIAJE">GUIAS DE VIAJE</option>
                        <option value="CONSEJOS DE VIAJES">CONSEJOS DE VIAJES</option>
                        <option value="EMPRENDIMIENTO">EMPRENDIMIENTO</option>
                        <option value="INVERSIONES">INVERSIONES</option>
                        <option value="ECONOMIA">ECONOMIA</option>
                        <option value="MARKETING">MARKETING</option>
                        <option value="DESCUBRIMIENTOS">DESCUBRIMIENTOS</option>
                        <option value="INVESTIGACIONES">INVESTIGACIONES</option>
                        <option value="EDUCACION">EDUCACION</option>
                        <option value="INNOVACION CIENTIFICA">INNOVACION CIENTIFICA</option>
                        <option value="FUTBOL">FUTBOL</option>
                        <option value="BALONCESTO">BALONCESTO</option>
                        <option value="DEPORTES EXTREMOS">DEPORTES EXTREMOS</option>
                        <option value="ATLETISMO">ATLETISMO</option>
                        <option value="DECORACION">DECORACION</option>                
                        <option value="JARDINERIA">JARDINERIA</option>
                        <option value="MUSICA">MUSICA</option>
                        <option value="SERIES Y PELICULAS">SERIES Y PELICULAS</option>
                        <option value="VIDEOJUEGOS">VIDEOJUEGOS</option>
                        <option value="CELEBRIDADES">CELEBRIDADES</option>                
                    </select>
                </div>
                <fieldset>
                    <legend>Etiquetas: </legend>
                    <div class="checkbox-group">
                        <label><input type="checkbox" name="tags" value="tecnologia"> Tecnología</label>
                        <label><input type="checkbox" name="tags" value="innovacion"> Innovacion</label>
                        <label><input type="checkbox" name="tags" value="moda"> Moda</label>
                        <label><input type="checkbox" name="tags" value="estilo de vida"> Estilo de Vida</label>
                        <label><input type="checkbox" name="tags" value="salud"> Salud</label>
                        <label><input type="checkbox" name="tags" value="bienestar"> Bienestar</label>
                        <label><input type="checkbox" name="tags" value="cultura"> Cultura</label>
                        <label><input type="checkbox" name="tags" value="arte"> Arte</label>
                        <label><input type="checkbox" name="tags" value="viajes"> Viajes</label>
                        <label><input type="checkbox" name="tags" value="turismo"> Turismo</label>
                        <label><input type="checkbox" name="tags" value="negocios"> Negocios</label>
                        <label><input type="checkbox" name="tags" value="finanzas"> Finanzas</label>
                        <label><input type="checkbox" name="tags" value="educacion"> Educacion</label>
                        <label><input type="checkbox" name="tags" value="ciencia"> Ciencia</label>
                        <label><input type="checkbox" name="tags" value="deportes"> Deportes</label>
                        <label><input type="checkbox" name="tags" value="entretenimiento"> Entretenimiento</label>
                        <label><input type="checkbox" name="tags" value="musica"> Musica</label>
                        <label><input type="checkbox" name="tags" value="cine"> Cine</label>
                        <label><input type="checkbox" name="tags" value="series"> Series</label>
                        <label><input type="checkbox" name="tags" value="videojuegos"> Videojuegos</label>
                        <label><input type="checkbox" name="tags" value="hogar"> Hogar</label>
                        <label><input type="checkbox" name="tags" value="jardineria"> Jardineria</label>
                        <label><input type="checkbox" name="tags" value="nutricion"> Nutricion</label>
                        <label><input type="checkbox" name="tags" value="ejercicio"> Ejercicio</label>
                        <label><input type="checkbox" name="tags" value="salud mental"> Salud Mental</label>
                        <label><input type="checkbox" name="tags" value="belleza"> Belleza</label>
                        <label><input type="checkbox" name="tags" value="accesorios"> Accesorios</label>
                        <label><input type="checkbox" name="tags" value="decoracion"> Decoracion</label>                    
                    </div>
                </fieldset> 
                <div class="radio-group">
                    <div>                    
                        <label for="comentario-si"><input type="radio" id="comentario-si" name="comentarios" value="SI"> Recibir Comentarios</label>                    
                        <label for="comentario-no"><input type="radio" id="comentario-no" name="comentarios" value="NO"> NO Recibir Comentarios</label>
                    </div>
                    <div>                    
                        <label for="likes-si"><input type="radio" id="likes-si" name="likes" value="SI"> Recibir Likes</label>                    
                        <label for="likes-no"><input type="radio" id="likes-no" name="likes" value="NO"> NO Recibir Likes</label>
                    </div>
                    <div>                    
                        <label for="suscripciones-si"><input type="radio" id="suscripciones-si" name="suscripciones" value="SI"> Recibir Suscripciones</label>                    
                        <label for="suscripciones-no"><input type="radio" id="suscripciones-no" name="suscripciones" value="NO"> NO Recibir Suscripciones</label>
                    </div>
                </div>
                <button type="submit">Crear Revista</button>
            </form>
        </div>
    </body>
</html>
