//SCRIPT PARA COMPORTAMIENTO DE INGREDIENTES

document.getElementById("add-ing").addEventListener("click", function(event) {
    event.preventDefault(); // Evita que el formulario se envíe

    // Captura los valores de los campos de entrada
    var ing = document.getElementById("ingrediente").value;
    var ingLabel = document.getElementById("ingrediente");
    var indexIng = ingLabel.selectedIndex;
    var indexTxt = ingLabel.options[indexIng].text;


    var cantidad = document.getElementById("cantidad").value;
    var unidad = document.getElementById("unidad").value;


    // Crea un nuevo elemento para los ingredientes
    var ingredientsGroup = document.createElement("div");
    ingredientsGroup.className = "ingredients-group";

    // Crea un botón para eliminar el grupo de ingredientes
    var deleteButton = document.createElement("button");
    deleteButton.className = "ingredients-group__btn";
    deleteButton.innerHTML = '<span class="material-symbols-outlined ingredients-group__icon">delete_forever</span>';
    deleteButton.addEventListener("click", function() {
        // Elimina el grupo de ingredientes cuando se hace clic en el botón de eliminar
        document.getElementById("ingredientes").removeChild(ingredientsGroup);
    });

    // Crea un párrafo para mostrar los ingredientes
    var ingredientParagraph = document.createElement("p");
    ingredientParagraph.className = "ingredients-group__name";
    ingredientParagraph.innerHTML = '<select class="form-ing__input" name="ingrediente[]"><option selected value="' + ing + '">' + indexTxt + '</option>' + 
        '<input type="text" name="cantidad[]" value="' + cantidad + '"> ' +
        '<input type="text" name="unidad[]" value="' + unidad + '">';

    // Agrega el botón y el párrafo al grupo de ingredientes
    ingredientsGroup.appendChild(deleteButton);
    ingredientsGroup.appendChild(ingredientParagraph);

    // Agrega el grupo de ingredientes al contenedor de ingredientes
    document.getElementById("ingredientes").appendChild(ingredientsGroup);

    // Resetear los valores de los campos de entrada
    document.getElementById("ingrediente").value = "";
    document.getElementById("cantidad").value = "";
    document.getElementById("unidad").value = "";
});






//SCRIPT PARA COMPORTAMIENTO DE PASOS

const addButton = document.getElementById('add-rec');
        const stepsContainer = document.getElementById('steps');
        const textareaInstruccion = document.getElementById('ta-instruccion');
        let paso = 1;

        addButton.addEventListener('click', function (e) {
            e.preventDefault();
            const instruccionText = textareaInstruccion.value.trim();
            if (instruccionText !== "") {
                const newInstruction = document.createElement('div');
                newInstruction.classList.add('steps-group');

                const deleteButton = document.createElement('button');
                deleteButton.classList.add('ingredients-group__btn');
                deleteButton.innerHTML = '<span class="material-symbols-outlined ingredients-group__icon">delete_forever</span>';
                deleteButton.addEventListener('click', function () {
                    stepsContainer.removeChild(newInstruction);
                });

                const pasoInput = document.createElement('input');
                pasoInput.type = 'number';
                pasoInput.value = paso++;
                pasoInput.classList.add('steps-group__number');
                pasoInput.readOnly = true;

                const instructionTextarea = document.createElement('textarea');
                instructionTextarea.classList.add('steps-group__text');
                instructionTextarea.name = 'ta-instruccion[]';
                instructionTextarea.value = instruccionText;
                instructionTextarea.readOnly = true;

                
                newInstruction.appendChild(deleteButton);
                newInstruction.appendChild(pasoInput);
                newInstruction.appendChild(instructionTextarea);

                stepsContainer.appendChild(newInstruction);

                textareaInstruccion.value = "";
            }
        });