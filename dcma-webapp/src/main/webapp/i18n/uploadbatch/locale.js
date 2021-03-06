/**
 * ******************************* Default locale
 * **************************************************
 */
var uploadBatchConstants = {
		tabLabel_home: "Home",
		tabLabel_batch_detail: "Batch Detail",
		tabLabel_web_scanner: "Web Scanner",
		tabLabel_upload_batch: "Upload Batch",
		associate_bcf_button: "Field(s)",
		bcf_name: "Name",
		bcf_value: "Value",
		upload_text: "Select image(s) to upload",
		upload_label: "<b><font color=\"black\">Upload Image(s)</font></b>",
		upload_button_label: "Upload Image(s)",
		reset: "Reset",
		finish_button_label : "Start Batch",
		ok: "Ok",
		cancel: "Cancel",
		delete_button_label : "Delete",
		select_all : "Select all",
		batch_detail : "<b><font color=\"black\">Batch Detail</font></b>",
		action : "<b><font color=\"black\">Action</font></b>",
		file_list : "<b><font color=\"black\">File List</font></b>",
		file_types : "tiff, tif and pdf files",
		upload_progress : "Uploaded: "
};

var uploadBatchMesseges = {
		upload_file_invalid_type: "Please select a valid upload file.Supported formats are tif, tiff or pdf.",
		upload_unsuccessful : "Error occurred while uploading file ",
		none_selected_warning: "No Batch class selected",
		error_retrieving_bcf : "Error in retrieving batch class field(s)",
		blank_error : "Mandatory fields cannot be blank.",
		invalid_regex_pattern : "Invalid regex pattern",
		waiting_message : "Please wait....Associating Field(s)",
		associate_batch_class_field_success : "Field(s) associated successfully",
		no_batch_class_field_found : "No Batch Class Field Found",
		error_saving_bcf : "Error in saving batch class field(s)",
		bcf_validation_regex_message : "Field value should be compliant with the pattern: ",
		batch_process_fail : "Could not start batch processing.",
		finish_upload_alert : "Your batch has been queued up for processing.",
		error_finish_clicked : "Please select at least a file for upload",
		file_upload_complete_alert : "File(s) uploaded successfully.",
		back_without_finish_upload : "Are you sure you want to leave upload batch?",
		error_deleting_bcf: "Error deleting the last associated Batch Class Field. Please try again.",
		error_deleting_files: "Error deleting the files at server. Please try again.",
		few_files_not_deleted: "Error deleting few files at server. Please try again.",
		success_deleting_files: "File(s) deleted successfully.",
		none_file_to_delete_selected_warning: "No files selected to delete.Please select at least one file",
		upload_image_limit_message: "Maximum permissible upload limit is ",
		upload_instance_limit_message: "Maximum batch processing limit has been reached.",
		limit_reached : "Limit Reached",
		file_size_exceed_meesage : " file(s) exceeded permissible file size limit of",
		upload_instance_limit_appended_message : "files. One or more uploaded files may contain more than 1 images."
};

/** ************************** Turkish locale (suffix: _tk)****************** */
var uploadBatchConstants_tk = {
		tabLabel_home: "Ev",
		tabLabel_batch_detail: "Ä°ÅŸ DetayÄ±",
		tabLabel_web_scanner: "Web TarayÄ±cÄ±",
		tabLabel_upload_batch: "Toplu Yükle",
		associate_bcf_button: "Alan (lar)",
		bcf_name: "Isim",
		bcf_value: "Değer",
		upload_text: "Yüklemek için resim seçin (ler)",
		upload_label: "<b><font color=\"black\">Yükle Görüntü (ler)</font></b>",
		upload_button_label: "Yükle Görüntü (ler)",
		reset: "Sıfırla",
		finish_button_label : "Toplu Başlat",
		ok: "Tamam",
		cancel: "iptal",
		delete_button_label : "silmek",
		select_all : "Hepsini Seç",
		batch_detail : "<b><font color=\"black\">Toplu Detay</font></b>",
		action : "<b><font color=\"black\">Eylem</font></b>",
		file_list : "<b><font color=\"black\">Dosya Listesi</font></b>",
		file_types : "tiff, tif ve pdf dosyalarını",
		upload_progress : "Gönderildi: "
};

var uploadBatchMesseges_tk = {		
		upload_file_invalid_type: "Etiketler: Lütfen seçin geçerli bir yükleme file.Supported formatları tif, tiff veya pdf.",
		upload_unsuccessful : "Dosyanız yüklenirken bir hata oluştu",
		none_selected_warning: "Toplu sınıf seçilen",
		error_retrieving_bcf : "Hata almak toplu sınıf alan (lar)",
		blank_error : "Zorunlu alanlar boş bırakılamaz.",
		invalid_regex_pattern : "Invalid regex pattern",
		waiting_message : "Lütfen bekleyin .... ilişkilendirilmesi Alan (lar)",
		associate_batch_class_field_success : "Alan (lar) başarılı biçimde ilişkilendirilse",
		no_batch_class_field_found : "Toplu Sınıf Alan Bulunamadı",
		error_saving_bcf : "Hata tasarrufu toplu sınıf alan (lar)",
		bcf_validation_regex_message : "Alan değeri desen uyumlu olmalıdır: ",
		batch_process_fail : "Toplu işlem başlatılamadı.",
		finish_upload_alert : "Toplu işlem için kuyruğa sahiptir.",
		error_finish_clicked : "Lütfen yüklemek için en az bir dosya seçin",
		file_upload_complete_alert : "Dosya (lar) başarıyla yüklendi.",
		back_without_finish_upload : "Yükleme toplu terk etmek istediğinizden emin mısınız?",
		error_deleting_bcf: "Son ilişkili Toplu Sınıf Alan silme hatası. Lütfen yeniden deneyin.",
		error_deleting_files: "Sunucuda dosyaları silerek hata. Lütfen yeniden deneyin.",
		few_files_not_deleted: "Sunucuda birkaç dosya silme hatası. Lütfen yeniden deneyin.",
		success_deleting_files: "Dosya (lar) başarıyla silindi.",
		none_file_to_delete_selected_warning: "Delete.Please için seçilen hiçbir dosya en az bir dosya seçin",
		upload_image_limit_message: "İzin verilen maksimum yükleme sınırı",
		upload_instance_limit_message: "Maksimum toplu işlem sınırına ulaşıldı.",
		limit_reached : "Ulaşıldı sınırlayın",
		file_size_exceed_meesage : " dosya (lar) aşıldı müsaade dosya boyutu limiti",
		upload_instance_limit_appended_message : "dosyaları. Bir veya daha fazla yüklenen dosyalar en fazla 1 görüntüler içerebilir."
};
