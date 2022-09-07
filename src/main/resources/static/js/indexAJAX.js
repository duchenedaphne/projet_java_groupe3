const fetchUsers = () => {
    $.ajax({
        method: 'GET',
        url: '/users',
        success: console.log('users fetched from database'),
        error: console.log('error fetching users from database')
    })
}

const fetchBuilding = () => {
    $.ajax({
        method: 'GET',
        url: '/habitations',
        success: console.log('buildings fetched from database'),
        error: console.log('error fetching buildings from database')
    })
}

const refreshBuilding = () => {
    console.log('boop');
    let form = $('.home_form');
    form.on('submit', (e) => {
        e.preventDefault();
        $.ajax({
            method: 'GET',
            url: form.attr('action'),
            success: (fragment) => {
                console.log('refresh buildings fetched from database')
                $('.mansio_card_wrapper').replaceWith(fragment);
            },
            error: console.log('error refreshing buildings from database')
        })
    })
}

console.log('indexAJAX.js loaded');

const addUser = () => {
    let form = $('.signup_form');
    form.on('submit', function(event) {
        event.preventDefault();
        console.log('form submitting');
        $.ajax({
            url: form.attr('action'),
            type: 'post',
            data: form.serialize(),
            success: console.log('users added to database'),
            error: console.log('error adding users to database')
        });
    })
};

const addHabitation = () => {
    let form = $('.ajouterHabitation_form');
    form.on('submit', function(event) {
        event.preventDefault();
        console.log('form submitting');
        $.ajax({
            url: form.attr('action'),
            type: 'post',
            data: form.serialize(),
            success: console.log('habitation added to database'),
            error: console.log('error adding habitation to database')
        });
    })
};


$('.signup__form_btn').click(addUser());
$('.ajouterHabitation__btn').click(addHabitation());
$('.refreshMansio').click(refreshBuilding());
$('.admin__nav__link').click(fetchUsers());
