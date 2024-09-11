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
            <form method="POST" action="${pageContext.servletContext.contextPath}/NuevaRevistaServlet" enctype="multipart/form-data">
                <input type="hidden" name="idUsuario" value="${param.id}">
                <div class="input-group">
                    <label for="nombreRevista">Nombre de la Revista:</label>
                    <input type="text" id="nombreRevista" name="nombreRevista"/>
                </div>
                <div class="input-group">
                    <label for="descripcionRevista">Descripcion de la Revista:</label>
                    <textarea id="descripcionRevista" name="descripcionRevista"></textarea>
                </div>                
                <div class="input-group">                        
                    <input type="file" name="pdfFile" id="pdfFile">                        
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
                        <option value="TENDENCIAS_DE_MODA">TENDENCIAS DE MODA</option>
                        <option value="BELLEZA">BELLEZA</option>
                        <option value="ACCESORIOS">ACCESORIOS</option>
                        <option value="NUTRICION">NUTRICION</option>
                        <option value="EJERCICIO">EJERCICIO</option>
                        <option value="SALUD_MENTAL">SALUD MENTAL</option>
                        <option value="MEDICINA_ALTERNATIVA">MEDICINA ALTERNATIVA</option>
                        <option value="PINTURA">PINTURA</option>
                        <option value="ESCULTURA">ESCULTURA</option>
                        <option value="LITERATURA">LITERATURA</option>
                        <option value="CINE">CINE</option>
                        <option value="DESTINOS_TURISTICOS">DESTINOS TURISTICOS</option>
                        <option value="GUIAS_DE_VIAJE">GUIAS DE VIAJE</option>
                        <option value="CONSEJOS_DE_VIAJES">CONSEJOS DE VIAJES</option>
                        <option value="EMPRENDIMIENTO">EMPRENDIMIENTO</option>
                        <option value="INVERSIONES">INVERSIONES</option>
                        <option value="ECONOMIA">ECONOMIA</option>
                        <option value="MARKETING">MARKETING</option>
                        <option value="DESCUBRIMIENTOS">DESCUBRIMIENTOS</option>
                        <option value="INVESTIGACIONES">INVESTIGACIONES</option>
                        <option value="EDUCACION">EDUCACION</option>
                        <option value="INNOVACION_CIENTIFICA">INNOVACION CIENTIFICA</option>
                        <option value="FUTBOL">FUTBOL</option>
                        <option value="BALONCESTO">BALONCESTO</option>
                        <option value="DEPORTES_EXTREMOS">DEPORTES EXTREMOS</option>
                        <option value="ATLETISMO">ATLETISMO</option>
                        <option value="DECORACION">DECORACION</option>                
                        <option value="JARDINERIA">JARDINERIA</option>
                        <option value="MUSICA">MUSICA</option>
                        <option value="SERIES_Y_PELICULAS">SERIES Y PELICULAS</option>
                        <option value="VIDEOJUEGOS">VIDEOJUEGOS</option>
                        <option value="CELEBRIDADES">CELEBRIDADES</option>                
                    </select>
                </div>
                <fieldset>
                    <legend>Etiquetas: </legend>
                    <div class="checkbox-group">
                        <label><input type="checkbox" name="tags" value="TECNOLOGIA"> Tecnología</label>
                        <label><input type="checkbox" name="tags" value="INNOVACION"> Innovacion</label>
                        <label><input type="checkbox" name="tags" value="MODA"> Moda</label>
                        <label><input type="checkbox" name="tags" value="ESTILO_DE_VIDA"> Estilo de Vida</label>
                        <label><input type="checkbox" name="tags" value="SALUD"> Salud</label>
                        <label><input type="checkbox" name="tags" value="BIENESTAR"> Bienestar</label>
                        <label><input type="checkbox" name="tags" value="CULTURA"> Cultura</label>
                        <label><input type="checkbox" name="tags" value="ARTE"> Arte</label>
                        <label><input type="checkbox" name="tags" value="VIAJES"> Viajes</label>
                        <label><input type="checkbox" name="tags" value="TURISMO"> Turismo</label>
                        <label><input type="checkbox" name="tags" value="NEGOCIOS"> Negocios</label>
                        <label><input type="checkbox" name="tags" value="FINANZAS"> Finanzas</label>
                        <label><input type="checkbox" name="tags" value="EDUCACION"> Educacion</label>
                        <label><input type="checkbox" name="tags" value="CIENCIA"> Ciencia</label>
                        <label><input type="checkbox" name="tags" value="DEPORTES"> Deportes</label>
                        <label><input type="checkbox" name="tags" value="ENTRETENIMISNTO"> Entretenimiento</label>
                        <label><input type="checkbox" name="tags" value="MUSICA"> Musica</label>
                        <label><input type="checkbox" name="tags" value="CINE"> Cine</label>
                        <label><input type="checkbox" name="tags" value="SERIES"> Series</label>
                        <label><input type="checkbox" name="tags" value="VIDEOJUEGOS"> Videojuegos</label>
                        <label><input type="checkbox" name="tags" value="HOGAR"> Hogar</label>
                        <label><input type="checkbox" name="tags" value="JARDINERIA"> Jardineria</label>
                        <label><input type="checkbox" name="tags" value="NUTRICION"> Nutricion</label>
                        <label><input type="checkbox" name="tags" value="EJERCICIO"> Ejercicio</label>
                        <label><input type="checkbox" name="tags" value="SALUD_MENTAL"> Salud Mental</label>
                        <label><input type="checkbox" name="tags" value="BELLEZA"> Belleza</label>
                        <label><input type="checkbox" name="tags" value="ACCESORIOS"> Accesorios</label>
                        <label><input type="checkbox" name="tags" value="DECORACION"> Decoracion</label>                    
                    </div>
                </fieldset> 
                <div class="radio-group">
                    <div>                    
                        <label for="comentario-si"><input type="radio" id="comentario-si" name="comentarios" value="SI" checked> Recibir Comentarios</label>                    
                        <label for="comentario-no"><input type="radio" id="comentario-no" name="comentarios" value="NO"> NO Recibir Comentarios</label>
                    </div>
                    <div>                    
                        <label for="likes-si"><input type="radio" id="likes-si" name="likes" value="SI" checked> Recibir Likes</label>                    
                        <label for="likes-no"><input type="radio" id="likes-no" name="likes" value="NO"> NO Recibir Likes</label>
                    </div>
                    <div>                    
                        <label for="suscripciones-si"><input type="radio" id="suscripciones-si" name="suscripciones" value="SI" checked> Recibir Suscripciones</label>                    
                        <label for="suscripciones-no"><input type="radio" id="suscripciones-no" name="suscripciones" value="NO"> NO Recibir Suscripciones</label>
                    </div>
                </div>
                <button type="submit">Crear Revista</button>
            </form>
        </div>
    </body>
</html>
