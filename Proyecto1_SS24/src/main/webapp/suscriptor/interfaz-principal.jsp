<%-- 
    Document   : interfaz-principal
    Created on : 5/09/2024, 22:25:15
    Author     : Carlos Cotom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pagina Principal (Suscriptor)</title>
        <link rel="stylesheet" href="suscriptor/style-interfaz-principal.css">
    </head>
    <body>
        <div class="sidebar">
            <h2>Menú</h2>
            <ul>
                <li><a href="#">Suscribir Revista</a></li>
                <li><a href="#">Perfil</a></li>
            </ul>
        </div>
        <div class="content">
            <h1>Bienvenido Suscriptor</h1>
            <div class="form-container">
                <h2>Busqueda de Revistas Suscritas</h2>
                <form method="POST" action="">
                    <h3>Filtrar por Categorias</h3>
                    <div class="checkbox-group">
                        <label><input type="checkbox" name="categorias" value="SOFTWARE"> SOFTWARE</label>
                        <label><input type="checkbox" name="categorias" value="IA"> IA</label>
                        <label><input type="checkbox" name="categorias" value="TENDENCIAS DE MODA"> TENDENCIAS DE MODA</label>
                        <label><input type="checkbox" name="categorias" value="BELLEZA"> BELLEZA</label>
                        <label><input type="checkbox" name="categorias" value="ACCESORIOS"> ACCESORIOS</label>
                        <label><input type="checkbox" name="categorias" value="NUTRICION"> NUTRICION</label>
                        <label><input type="checkbox" name="categorias" value="EJERCICIO"> EJERCICIO</label>
                        <label><input type="checkbox" name="categorias" value="SALUD MENTAL"> SALUD MENTAL</label>
                        <label><input type="checkbox" name="categorias" value="MEDICINA ALTERNATIVA"> MEDICINA ALTERNATIVA</label>
                        <label><input type="checkbox" name="categorias" value="PINTURA"> PINTURA</label>
                        <label><input type="checkbox" name="categorias" value="ESCULTURA"> ESCULTURA</label>
                        <label><input type="checkbox" name="categorias" value="LITERATURA"> LITERATURA</label>
                        <label><input type="checkbox" name="categorias" value="CINE"> CINE</label>
                        <label><input type="checkbox" name="categorias" value="DESTINOS TURISTICOS"> DESTINOS TURISTICOS</label>
                        <label><input type="checkbox" name="categorias" value="GUIAS DE VIAJE"> GUIAS DE VIAJE</label>
                        <label><input type="checkbox" name="categorias" value="CONSEJOS DE VIAJES"> CONSEJOS DE VIAJES</label>
                        <label><input type="checkbox" name="categorias" value="EMPRENDIMIENTO"> EMPRENDIMIENTO</label>
                        <label><input type="checkbox" name="categorias" value="INVERSIONES"> INVERSIONES</label>
                        <label><input type="checkbox" name="categorias" value="ECONOMIA"> ECONOMIA</label>
                        <label><input type="checkbox" name="categorias" value="MARKETING"> MARKETING</label>
                        <label><input type="checkbox" name="categorias" value="DESCUBRIMIENTOS"> DESCUBRIMIENTOS</label>
                        <label><input type="checkbox" name="categorias" value="INVESTIGACIONES"> INVESTIGACIONES</label>
                        <label><input type="checkbox" name="categorias" value="EDUCACION"> EDUCACION</label>
                        <label><input type="checkbox" name="categorias" value="INNOVACION CIENTIFICA"> INNOVACION CIENTIFICA</label>
                        <label><input type="checkbox" name="categorias" value="FUTBOL"> FUTBOL</label>
                        <label><input type="checkbox" name="categorias" value="BALONCESTO"> BALONCESTO</label>
                        <label><input type="checkbox" name="categorias" value="DEPORTES EXTREMOS"> DEPORTES EXTREMOS</label>
                        <label><input type="checkbox" name="categorias" value="ATLETISMO"> ATLETISMO</label>                    
                        <label><input type="checkbox" name="categorias" value="DECORACION"> DECORACION</label>                    
                        <label><input type="checkbox" name="categorias" value="JARDINERIA"> JARDINERIA</label>                    
                        <label><input type="checkbox" name="categorias" value="MUSICA"> MUSICA</label>                    
                        <label><input type="checkbox" name="categorias" value="SERIES Y PELICULAS"> SERIES Y PELICULAS</label>                    
                        <label><input type="checkbox" name="categorias" value="VIDEOJUEGOS"> VIDEOJUEGOS</label>                    
                        <label><input type="checkbox" name="categorias" value="CELEBRIDADES"> CELEBRIDADES</label>                    
                    </div>
                    <h3>Filtrar por Etiquetas</h3>
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
                    <button type="submit">Buscar Revistas</button>
                </form>
            </div>
            <div class="revistas-container">
                <h2 style="text-align: center;">Revistas Suscritas</h2>
                <div>
                    <h3>Revista</h3>
                    <a href="#">Leer</a>                   
                    <a href="#">Descargar</a>                   
                    <a href="#">Comentar</a>                   
                    <a href="#">Autor</a>                   
                    <a href="#">Dar Like</a>                   
                    <hr>
                </div>
                <div>
                    <h3>Revista</h3>
                    <a href="#">Leer</a>                   
                    <a href="#">Descargar</a>                   
                    <a href="#">Comentar</a>                   
                    <a href="#">Autor</a>                   
                    <a href="#">Dar Like</a>                   
                    <hr>
                </div>
            </div>           
        </div> 
    </body>
</html>
