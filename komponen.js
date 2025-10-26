
document.addEventListener('DOMContentLoaded', function() {
    
   
    const orderForm = document.getElementById('order-form');
    const inputNama = document.getElementById('nama-mahasiswa');
    const inputKode = document.getElementById('kode-buku');
    const inputJumlah = document.getElementById('jumlah');
    

    const errorNama = document.getElementById('nama-error');
    const errorKode = document.getElementById('kode-error');
    const errorJumlah = document.getElementById('jumlah-error');
    
   
    const tableBody = document.getElementById('order-list');
    const totalItems = document.getElementById('total-items');
    
   
    const modal = document.getElementById('modal-overlay');
    const modalMessage = document.getElementById('modal-message');
    const modalCloseBtn = document.getElementById('modal-close-btn');

    
   
    orderForm.addEventListener('submit', function(event) {
        
        event.preventDefault(); 
        
       
        if (validateForm()) {
            addOrderToTable();
            showModal(`Pesanan untuk '${inputNama.value}' berhasil ditambahkan!`);
           
            orderForm.reset();
        }
    });

    function validateForm() {
        let isValid = true;
        
        
        errorNama.textContent = '';
        errorKode.textContent = '';
        errorJumlah.textContent = '';
        
        
        const nama = inputNama.value.trim();
        const kode = inputKode.value.trim();
        const jumlah = inputJumlah.value.trim();
        
       
        if (nama === '') {
            errorNama.textContent = 'Nama mahasiswa tidak boleh kosong.';
            isValid = false;
        }
        
        
        if (kode === '') {
            errorKode.textContent = 'Kode bahan ajar tidak boleh kosong.';
            isValid = false;
        }
        
        
        if (jumlah === '') {
            errorJumlah.textContent = 'Jumlah tidak boleh kosong.';
            isValid = false;
        } else if (isNaN(jumlah) || parseInt(jumlah) <= 0) {
            errorJumlah.textContent = 'Jumlah harus berupa angka lebih dari 0.';
            isValid = false;
        }
        
        return isValid;
    }

    
    function addOrderToTable() {
        const nama = inputNama.value.trim();
        const kode = inputKode.value.trim();
        const jumlah = parseInt(inputJumlah.value.trim());
        
       
        const newRow = tableBody.insertRow();
        
        
        const cellNo = newRow.insertCell(0);
        const cellNama = newRow.insertCell(1);
        const cellKode = newRow.insertCell(2);
        const cellJumlah = newRow.insertCell(3);
        const cellAksi = newRow.insertCell(4);
        
        
        cellNo.textContent = tableBody.rows.length; 
        cellNama.textContent = nama;
        cellKode.textContent = kode;
        cellJumlah.textContent = jumlah;
        
        
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Hapus';
        deleteButton.className = 'delete-btn';
        

        deleteButton.addEventListener('click', function() {
            deleteRow(newRow);
        });
        
       
        cellAksi.appendChild(deleteButton);
        
        
        updateTotalItems();
    }

    
    function deleteRow(rowElement) {
        rowElement.remove();
        
        updateRowNumbers();
        
        updateTotalItems();
    }

    
    function updateRowNumbers() {
        const rows = tableBody.getElementsByTagName('tr');
        for (let i = 0; i < rows.length; i++) {
            rows[i].cells[0].textContent = i + 1;
        }
    }

   
    function updateTotalItems() {
        totalItems.textContent = tableBody.rows.length;
    }
    
    
    function showModal(message) {
        modalMessage.textContent = message;
        modal.style.display = 'flex'; 
    }
    
    function hideModal() {
        modal.style.display = 'none'; 
    }
    
    
    modalCloseBtn.addEventListener('click', hideModal);
    
    
    modal.addEventListener('click', function(event) {
        if (event.target === modal) {
            hideModal();
        }
    });

});