  //SCRIPT PARA COMPORTAMIENTO DE agregar stock
  
  document.getElementById("add-item").addEventListener("click", function(event) {
  event.preventDefault(); // Evita que el formulario se envíe

  // Captura los valores de los campos de entrada
  var ing = document.getElementById("item").value;
  var itemLabel = document.getElementById("item");
  var indexItem = itemLabel.selectedIndex;
  var indexTxt = itemLabel.options[indexItem].text;


  var cantidad = document.getElementById("cantidad").value;
  var unidad = document.getElementById("unidad").value;


  // Crea un nuevo elemento para los ingredientes
  var itemGroup = document.createElement("div");
  itemGroup.className = "ingredients-group";

  // Crea un botón para eliminar el grupo de ingredientes
  var deleteButton = document.createElement("button");
  deleteButton.className = "ingredients-group__btn";
  deleteButton.innerHTML = '<span class="material-symbols-outlined ingredients-group__icon">delete_forever</span>';
  deleteButton.addEventListener("click", function() {
      // Elimina el grupo de ingredientes cuando se hace clic en el botón de eliminar
      document.getElementById("ingredientes").removeChild(itemGroup);
  });

  // Crea un párrafo para mostrar los ingredientes
  var ingredientParagraph = document.createElement("p");
  ingredientParagraph.className = "ingredients-group__name";
  ingredientParagraph.innerHTML = '<select class="form-ing__input" name="ingrediente[]"><option selected value="' + ing + '">' + indexTxt + '</option>' + 
      '<input type="text" name="cantidad[]" value="' + cantidad + '"> ' +
      '<input type="text" name="unidad[]" value="' + unidad + '">';

  // Agrega el botón y el párrafo al grupo de ingredientes
  itemGroup.appendChild(deleteButton);
  itemGroup.appendChild(ingredientParagraph);

  // Agrega el grupo de ingredientes al contenedor de ingredientes
  document.getElementById("itemcitos").appendChild(itemGroup);

  // Resetear los valores de los campos de entrada
  document.getElementById("item").value = "";
  document.getElementById("cantidad").value = "";
  document.getElementById("unidad").value = "";
});
