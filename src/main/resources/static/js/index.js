/*============================================================================

                                    ANIME.JS
  
============================================================================*/
console.log('test');

// On "Inscription" button click, pop out the sign up panel
$(".signup_btn span").click(function() {
    console.log('signup btn clicked');

    $('.signup__drawer').css("display", "flex");
    $('.signup__drawer').css("opacity", "1");
    $('.user__see-more').css("display", "none");
    $('.bien__drawer').css("display", "none");

    anime({
        targets: 'body',
        translateX: '-30vw',
        easing: 'cubicBezier(0.510, 0.075, 0.615, 1.005)',
        duration: 500,
    });

    console.log('animation completed');
});

// On "VOIR PLUS" button click, pop out the see more panel
$(".ajouterBien_btn").click(function() {
    console.log('admin btn clicked');

    $('.signup__drawer').css("opacity", "0");
    $('.signup__drawer').css("display", "none");
    $('.user__see-more').css("display", "none");
    $('.user__see-more').css("opacity", "0");
    $('.bien__drawer').css("display", "flex");
    $('.bien__drawer').css("opacity", "1");

    anime({
        targets: 'body',
        translateX: '-30vw',
        easing: 'cubicBezier(0.510, 0.075, 0.615, 1.005)',
        duration: 500,
    });

    console.log('animation completed');
});

// On "VOIR PLUS" button click, pop out the see more panel
$(".admin__btn--voir").click(function() {
    console.log('admin btn clicked');

    $('.signup__drawer').css("opacity", "0");
    $('.signup__drawer').css("display", "none");
    $('.bien__drawer').css("opacity", "0");
    $('.bien__drawer').css("display", "none");
    $('.user__see-more').css("display", "flex");
    $('.user__see-more').css("opacity", "1");

    anime({
        targets: 'body',
        translateX: '-30vw',
        easing: 'cubicBezier(0.510, 0.075, 0.615, 1.005)',
        duration: 500,
    });

    console.log('animation completed');
});

// On "Close" button click, draw back the sign up panel
$(".drawer__close, .adminQuit__nav__link, .admin__nav__link, .finalSubmit").click(function() {
    console.log('close btn clicked');

    anime({
        targets: 'body',
        translateX: '0vw',
        easing: 'cubicBezier(0.510, 0.075, 0.615, 1.005)',
        duration: 500,
    });

    console.log('animation completed');
    setTimeout(() => {
        $('.signup__drawer').css("opacity", "0");
        $('.signup__drawer').css("display", "none");
        $('.bien__drawer').css("opacity", "0");
        $('.bien__drawer').css("display", "none");
        $('.user__see-more').css("opacity", "0");
        $('.user__see-more').css("display", "none");
    }, 500)
});


/*============================================================================

                              IMAGE SCALE ON HOVER

============================================================================*/

let imageArray = document.querySelectorAll('.mansio_card_img');
let imageInnerArray = document.querySelectorAll('.mansio_card_img_inner');

const random = (min, max) => { // min and max included
    return Math.floor(Math.random() * (max - min + 1) + min)
}

console.log(imageArray);

for(let key of imageArray.keys()) {
    console.log(key);
    const classList = ['img1', 'img2','img3','img4','img5','img6','img7','img8','img9','img10','img11','img12','img13','img14'];



    imageArray.forEach(() => {
        classList.forEach(c => {
            if (imageArray[key].classList.contains(c)) {
                imageArray[key].classList.remove(c);
            }
        });

        let randomNb = random(1, 14);
        $(imageArray[key]).addClass('img' + randomNb);

        imageArray[key].addEventListener('mouseenter', () => {
            gsap.killTweensOf(imageInnerArray[key]);
            gsap.to(imageInnerArray[key], {
                duration: 2,
                ease: 'expo',
                scale: 1.5
            });
        });

        imageArray[key].addEventListener('mouseleave', () => {
            gsap.killTweensOf(imageInnerArray[key]);
            gsap.to(imageInnerArray[key], {
                duration: 0.7,
                ease: 'expo',
                scale: 1
            });
        });
    })
}

/*============================================================================

                                    TEST FNs

============================================================================*/

$(DOM.links.nav.start).click(indexLoadStartAnim());



/*============================================================================
                          ON MANSIO CATEGORY.CLICK
============================================================================*/

$(DOM.content.navigation.textWrapper).click(() => {
    indexSecondLoadAnim();

    if($('.search_btn').hasClass("clickedSearch")){
        $('.search_btn').removeClass("clickedSearch");
        $('.search_btn').addClass("firstClick");
    }
})


/*============================================================================
                              ON SEARCH.CLICK
============================================================================*/

$('.firstClick').click(() => {
    console.log('searchBtn clicked');
    searchLinkClick();
    $('.search_btn').toggleClass("firstClick");
    $('.search_btn').toggleClass("clickedSearch");
})

$('.clickedSearch').click(() => {
    console.log('searchBtn clicked again');
    searchLinkAlreadyClicked();
})



/*============================================================================
                          ON MANSIO CATEGORY.CLICK
============================================================================*/

$(DOM.mansio.category.links).click(() => {
    mansioCardLeaveAnim();
    mansioCardStartAnim(0);
})


/*============================================================================
                          ON NAV ADMIN.CLICK
============================================================================*/

$(DOM.links.navAdmin.adminLink).click(() => {
    adminEnterLink();
})


/*============================================================================
                          ON NAV LEAVE.CLICK
============================================================================*/

$(DOM.links.navAdmin.adminQuit).click(() => {
    adminLeaveLink();
})


/*============================================================================
                          DRAG SCROLL
============================================================================*/
const slider = document.querySelector('.mansio_card_wrapper');
let isDown = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', (e) => {
    isDown = true;
    slider.classList.add('active');
    startX = e.pageX - slider.offsetLeft;
    scrollLeft = slider.scrollLeft;
});
slider.addEventListener('mouseleave', () => {
    isDown = false;
    slider.classList.remove('active');
});
slider.addEventListener('mouseup', () => {
    isDown = false;
    slider.classList.remove('active');
});
slider.addEventListener('mousemove', (e) => {
    if(!isDown) return;
    e.preventDefault();
    const x = e.pageX - slider.offsetLeft;
    const walk = (x - startX) * 3; //scroll-fast
    slider.scrollLeft = scrollLeft - walk;
    console.log(walk);
});