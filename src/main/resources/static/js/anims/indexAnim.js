/*============================================================================
                                    DOM VARIABLES
============================================================================*/
Splitting();

let DOM = {
    content: {
        layouts: {
            home: document.querySelector('.home_wrapper'),
            mansio: document.querySelector('.habitat_list_wrapper'),
            admin: document.querySelector('.admin__wrapper')
        },
        banner: {
            section: document.querySelector('.banner_title'),
            get chars() {
                return this.section.querySelectorAll('.content__paragraph .word > .char, .whitespace');
            },
            wrapper: document.querySelector('.banner_wrapper')
        },
        bannerText: {
            section: document.querySelector('.banner_text'),
            get chars() {
                return this.section.querySelectorAll('.content__paragraphs .word > .char, .whitespace');
            }
        },
        bannerImg: {
            section: document.querySelector('.banner_wrapper__bg'),
        },
        homeSearch: {
            section: document.querySelector('.home_form_wrapper'),
            search: document.querySelector('.search_btn'),
            hidden: document.querySelector('.cell--hidden'),
            cells: document.querySelectorAll('.home_form_cell'),
            inputs: document.querySelectorAll('.home_form_cell select')
        },
        navigation: {
            section: document.querySelector('.navigation'),
            navChildren: document.querySelector('.navigation').children,
            textWrapper: document.querySelector('.logo_wrapper'),
            textInner: document.querySelector('.logo__text'),
            word: document.querySelectorAll('.logo__text .word'),
            titleChars: document.querySelectorAll('.logo__text .word span.char'),
            titleCloneChars: document.querySelectorAll('.logo__text .word--clone span.char')
        }
    },
    links: {
        nav: {
            start: document.querySelector('.start__btn'),
            startSecond: document.querySelector('.startSecond__btn'),
            reverse: document.querySelector('.reverse__btn'),
            startRotate: document.querySelector('.startRotate__btn'),
            reverseRotate: document.querySelector('.reverseRotate__btn')
        },
        navAdmin: {
            adminLink: document.querySelector('.admin__nav__link'),
            adminQuit: document.querySelector('.adminQuit__nav__link'),
            start: document.querySelector('.navi .start__btn'),
            startSecond: document.querySelector('.navi .startSecond__btn'),
            reverse: document.querySelector('.navi .reverse__btn'),
            startRotate: document.querySelector('.navi .startRotate__btn'),
            reverseRotate: document.querySelector('.navi .reverseRotate__btn')
        }
    },
    mansio: {
        category: {
            startCard: document.querySelector('.startCard'),
            reverseCard: document.querySelector('.reverseCard'),
            links: document.querySelectorAll('.mansio__category__cell p')
        },
        cards: {
            cardsArray: document.querySelectorAll('.mansio_card')
        }
    },
    adminPage: {
        text: {
            title: document.querySelector('.admin__title'),
            get chars() {
                return this.title.querySelectorAll('.admin__title .word > .char');
            },
            links: document.querySelectorAll('.admin__menu__link'),
            userLink: document.querySelector('.user__link'),
            estateLink: document.querySelector('.estate__link')
        },
        entries: {
            entryLines: document.querySelectorAll('.admin__user__entry'),
            entryContent: document.querySelectorAll('.admin__user__entry__cell')
        }
    },
    misc: {
        overlays: document.querySelectorAll('.overlay__row')
    }
};

let wordClone = document.querySelector('.logo__text .word').cloneNode(true);
wordClone.classList.add('word--clone');
DOM.content.navigation.textInner.appendChild(wordClone);

let titleChars = document.querySelectorAll('.logo__text .word span.char');
let titleCloneChars = document.querySelectorAll('.logo__text .word--clone span.char');


/*============================================================================
                                    HOME/BANNER TITLE
============================================================================*/

timelineSettings = {
    staggerValue: 0.04,
    charsDuration: 2
};

animateCharsTimeline = gsap.timeline({
    defaults: {duration: 0.5, ease: 'power2', stagger: 0.025}
})

const timeline = gsap.timeline();

const indexLoadStartAnim = () => {
    timeline
        .from( DOM.content.banner.chars, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '100%',
            opacity: 0,
            color: '#FFFFFF',
            stagger: timelineSettings.staggerValue})
        .addLabel('second')
        .from( DOM.content.bannerText.chars, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '-100%',
            opacity: 0,
            color: '#FFFFFF',
            delay: 0.5,
            stagger: 0.004}, 'second')
        .from( DOM.content.homeSearch.section, {
            duration: 1,
            ease: 'Power3.easeOut',
            delay: 6,
            width: 0,
            opacity: 0}, 'second')
        .from( DOM.content.homeSearch.cells, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            delay: 0.2,
            x: '100%',
            stagger: 0.314,
            opacity: 0})
        .from( DOM.content.navigation.section, {
            duration: 1,
            ease: 'Power3.easeOut',
            delay: 6,
            y: '-100%',
            opacity: 0}, 'second')
        .from( DOM.content.bannerImg.section, {
            duration: 1,
            ease: 'Power3.easeOut',
            delay: 5,
            opacity: 0}, 'second')
        .to(DOM.content.banner.chars, {
            ease: 'Power3.easeOut',
            duration: 1,
            delay: 5,
            color: '#000000',
        }, 'second')
        .to(DOM.content.bannerText.chars, {
            ease: 'Power3.easeOut',
            duration: 1,
            delay: 5,
            color: '#000000',
        }, 'second');

    pageLogoRotate();
}

const indexSecondLoadAnim = () => {
    timelineSettings = {
        staggerValue: 0.004,
        charsDuration: 0.4
    };

    timeline
        .addLabel('start')
        .to( DOM.content.homeSearch.section, {
            duration: 1,
            ease: 'Power3.easeOut',
            top: 'calc(65vh - 60px)',
            bottom: '-60px',
            backgroundColor: 'var(--primary-color)',
            stagger: timelineSettings.staggerValue}, 'start')
        .to( DOM.content.homeSearch.inputs, {
            duration: 0.5,
            ease: 'Power3.easeOut',
            backgroundColor: 'var(--primary-color)',
            color: '#000000',
            stagger: timelineSettings.staggerValue}, 'start')
        .to(DOM.content.banner.wrapper, {
            height: '65vh'
        }, 'start')
        .to( DOM.content.banner.chars, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '0',
            opacity: 1,
            color: '#000000 !important',
            stagger: timelineSettings.staggerValue})
        .addLabel('second')
        .to( DOM.content.bannerText.chars, {
            startAt: { color: '#000000', opacity: 1 },
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '0',
            opacity: 1,
            color: '#000000 !important',
            delay: 0.5,
            stagger: 0.004}, 'start')
        .to( DOM.content.bannerImg.section, {
            duration: 1,
            ease: 'Power3.easeOut',
            delay: 0.5,
            opacity: 1}, 'start')
        .to(DOM.content.layouts.mansio, {
            duration: timelineSettings.charsDuration,
            top: '25vh',
            y: '100%',
            opacity: 0
        }, 'start')

    inversePageLogoRotate();
}

const indexLeaveAnim = () => {
    inversePageLogoRotate();

    timelineSettings = {
        staggerValue: 0.004,
        charsDuration: 0.314
    };

    timeline.addLabel('start')
        .set(DOM.content.banner.chars, {
            opacity: 1
        })
        .to( DOM.content.banner.chars, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeIn',
            y: '-100%',
            opacity: 0,
            stagger: timelineSettings.staggerValue})
        .to( DOM.content.bannerText.chars, {
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeIn',
            y: '100%',
            opacity: 0,
            stagger: timelineSettings.staggerValue}, 'start')
        .to( DOM.content.bannerImg.section, {
            duration: 0.5,
            ease: 'Power3.easeOut',
            opacity: 0})
        .to( DOM.content.homeSearch.section, {
            duration: 0.5,
            delay: 1,
            ease: 'Power3.easeOut',
            position: 'absolute',
            top: 0,
            backgroundColor: 'var(--anthracite)',
            stagger: timelineSettings.staggerValue}, 'start')
        .to( DOM.content.homeSearch.inputs, {
            duration: 0.5,
            delay: 1,
            ease: 'Power3.easeOut',
            backgroundColor: 'var(--anthracite)',
            color: '#FFFFFF',
            stagger: timelineSettings.staggerValue}, 'start')
        .to(DOM.content.banner.wrapper, {
            duration: 1,
            delay: 1,
            height: '150px'}, 'start')
}

const pageLogoRotate = () => {
    animateCharsTimeline
        .to(titleChars, {
            y: '100%',
            rotationX: -90,
            opacity: 0
        })
        .to(titleCloneChars, {
            startAt: {y: '-100%', rotationX: 90, opacity: 0},
            y: '0%',
            rotationX: 0,
            opacity: 1
        });
}

const inversePageLogoRotate = () => {
    animateCharsTimeline
        .to(titleChars, {
            y: '-100%',
            rotationX: 90,
            opacity: 0
        })
        .to(titleCloneChars, {
            startAt: {y: '100%', rotationX: 90, opacity: 0},
            y: '0',
            rotationX: 0,
            opacity: 1
        });
}

/*

DOM.content.navigation.textWrapper.addEventListener('mouseenter', () => {
  pageLogoRotate()
});

DOM.content.navigation.textWrapper.addEventListener('mouseleave', () => {
  inversePageLogoRotate();
});

*/

const searchLinkClick = () => {
    indexLeaveAnim();
    timeline
        .addLabel('start')
        .set(DOM.content.layouts.mansio, {opacity: 0, width: '90vw'})
        .add(mansioCardStartAnim(1.5))
        .to(DOM.content.layouts.mansio, {
            y: '0',
            position: 'absolute',
            top: '5vh',
            delay: 1.5,
            duration: 1,
            opacity: 1
        }, 'start')
}

const searchLinkAlreadyClicked = () => {
    mansioCardLeaveAnim(1.5).reverse();
    mansioCardLeaveAnim(1.5);
}

const mansioCardStartAnim = (delayInput) => {
    timelineSettings = {
        staggerValue: 0.3,
        charsDuration: 0.314
    };

    timeline.addLabel('start')
        .to(DOM.mansio.cards.cardsArray, {
            startAt: { x: '100%', opacity: 0 },
            duration: timelineSettings.charsDuration,
            delay: delayInput,
            ease: 'Power3.easeOut',
            x: '0',
            opacity: 1,
            stagger: timelineSettings.staggerValue});

    console.log('animation completed');
}

const mansioCardLeaveAnim = () => {
    timelineSettings = {
        staggerValue: 0.2,
        charsDuration: 0.314
    };

    timeline.addLabel('start')
        .to(DOM.mansio.cards.cardsArray, {
            startAt: { x: '100%', opacity: 1 },
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            x: '-100%',
            opacity: 0,
            stagger: timelineSettings.staggerValue});

    console.log('animation completed');
}



const adminEnterLink = () => {
    console.log('adminEnter');

    const adminTimeline = gsap.timeline({
        defaults: {
            duration: 0.5,
            ease: 'power3.inOut'
        }
    });

    const timelineSettings = {
        staggerValue: 0.2,
        charsDuration: 1
    };

    adminTimeline
        .to(DOM.misc.overlays, {
            scaleY: 1
        })
        .to(DOM.links.navAdmin.adminLink, {opacity: 0})
        .to(DOM.links.navAdmin.adminQuit, {display: 'block'})
        .addLabel('hidden')
        .to(DOM.content.layouts.admin, {
            duration: 1.5,
            opacity: 1,
            y: '0',
            top: 0,
            stagger: 0.25
        })
        .to(DOM.content.layouts.home, {
            duration: 1,
            opacity: 0,
        }, 'hidden')
        .to(DOM.content.layouts.mansio, {
            duration: 1,
            opacity: 0,
        }, 'hidden')
        .addLabel('contentReveal')
        .to(DOM.misc.overlays, {
            //ease: 'expo',
            scaleY: 0
        })
        .from(DOM.adminPage.text.title, {
            delay: 0.5,
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '100%',
            stagger: timelineSettings.staggerValue}, 'contentReveal')
        .from(DOM.adminPage.text.links, {
            delay: 0.5,
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            x: '-100%',
            stagger: timelineSettings.staggerValue
        }, 'contentReveal')
        .from(DOM.adminPage.entries.entryLines, {
            delay: 0.5,
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            x: '100%',
            stagger: timelineSettings.staggerValue
        }, 'contentReveal')
}



const adminLeaveLink = () => {
    console.log('adminLeave');

    const adminTimeline = gsap.timeline({
        defaults: {
            duration: 0.5,
            ease: 'power3.inOut'
        }
    });

    const timelineSettings = {
        staggerValue: 0.2,
        charsDuration: 1
    };

    adminTimeline
        .to(DOM.adminPage.text.title, {
            delay: 0.5,
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            y: '-100%',
            stagger: timelineSettings.staggerValue}, 'contentReveal')
        .to(DOM.adminPage.text.links, {
            delay: 0.5,
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            x: '-100%',
            stagger: timelineSettings.staggerValue
        }, 'contentReveal')
        .to(DOM.adminPage.entries.entryLines, {
            opacity: 0,
            duration: timelineSettings.charsDuration,
            ease: 'Power3.easeOut',
            x: '100%',
            stagger: timelineSettings.staggerValue
        }, 'contentReveal')
        .addLabel('contentReveal')
        .to(DOM.misc.overlays, {
            scaleY: 1
        })
        .to(DOM.links.navAdmin.adminLink, {opacity: 1})
        .to(DOM.links.navAdmin.adminQuit, {display: 'none'})
        .addLabel('hidden')
        .to(DOM.content.layouts.admin, {
            duration: 1.5,
            opacity: 0,
            y: '0',
            top: '100%',
            stagger: 0.25
        })
        .addLabel('contentReveal')
        .to(DOM.misc.overlays, {
            //ease: 'expo',
            scaleY: 0
        })
        .to(DOM.content.layouts.home, {
            duration: 1,
            opacity: 1,
        }, 'hidden')
        .to(DOM.content.layouts.mansio, {
            duration: 1,
            opacity: 1,
        }, 'hidden')
        .set(DOM.adminPage.text.links, {opacity: 1, x: 0})
        .set(DOM.adminPage.text.title, {opacity: 1, y: 0})
        .set(DOM.adminPage.entries.entryLines, {opacity: 1, x: 0})
}

