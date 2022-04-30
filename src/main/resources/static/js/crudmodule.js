let callApi = {
    save: (dto) => {
        $.ajax({
            url: '/board/apis/save',
            type: 'post',
            data: dto,
            contentType: 'application/json',
            dataType: 'text',
            success: (result) => {
                console.log(result);
            }
        });
    },
    delete: (id) => {
        $.ajax({
            url: '/board/apis/delete/' + id,
            type: 'delete',
            dataType: 'text',
            success: (result) => {
                console.log(result);
            }
        })
    }
}

export default callApi;