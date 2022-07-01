$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/pacientes",
            success: function(response){
              $.each(response, (i, paciente) => {
              console.log("desde get " + paciente)
                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' + 
                                            paciente.id +
                                            '</button>';
                 let deleteButton = '<button' +
                                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                                      ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                                      '&times' +
                                                      '</button>';
                let tr_id = 'tr_' + paciente.id;
                let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                          '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                          '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                          '<td class=\"td_fechaIngreso\">' + new Date(paciente.fechaIngreso).toISOString().slice(0,10) + '</td>' +
                          '<td class=\"td_domicilio\">' + paciente.domicilio.calle + ' ' + paciente.domicilio.numero + '</td>' +
                          '<td class=\"td_email\">' + paciente.email + '</td>' +
                            '<td>' + deleteButton + '</td>' +
                          '</tr>';                
                $('#pacienteTable tbody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});