//Estilos para tabla pedido

// Espera a que se cargue completamente el documento HTML
document.addEventListener("DOMContentLoaded", function() {
    // Obtén todas las filas de la tabla excepto la primera (encabezados)
    const filas = document.querySelectorAll(".table__row:not(:first-child)");
  
    // Recorre todas las filas y modifica la clase del elemento <p> en la última celda
    filas.forEach(function (fila) {
      const ultimaCelda = fila.querySelector(".table__td:last-child p");
      const estado = ultimaCelda.textContent.trim();
      
      // Agrega la clase 
      switch (estado) {
        case "Completado":
          ultimaCelda.classList.add("completado");
          break;
        case "Pendiente":
          ultimaCelda.classList.add("pendiente");
          break;
        case "En Proceso":
          ultimaCelda.classList.add("proceso");
          break;
        case "Aceptado":
          ultimaCelda.classList.add("aceptado");
          break;
        case "Entregado":
          ultimaCelda.classList.add("entregado");
          break;
        case "Cancelado":
          ultimaCelda.classList.add("cancelado");
          break;
        default:
          break;
      }
    });
  });