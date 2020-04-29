/*
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 *
 * Template Name: Sasna - Multipurpose Business HTML Template   
 * Template URI: https://thememarch.com/demo/html/sasna/
 * Description: Sasna is a multipurpose business HTML template which comes with the unique and clean design. It helps you to create a beautiful multipurpose business HTML website. It has also e-commerce support. E-commerce pages are included on this template.
 * Author: Thememarch
 * Author URI: https://thememarch.com
 * Version: 4.5
 *
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */


/*
===========================================================
    INDEX
===========================================================

    01) Color Customizer
    02) Preloader Activation
    03) Meanmenu Activation
    04) Inline Background Image
    05) Header Search Form
    06) Heroslider Height
    07) Button Effect
    08) Slider Activations
        08.01) Heroslider Activation
        08.02) Heroslider Activation 2
        08.03) Feature Slider Activation
        08.04) Testimonial Slider
        08.05) Testimonial Slider 2
        08.06) Product Vertical Slider 
        08.07) Blog Slider Activation
        08.08) Brand Logo Slider
        08.09) Portfolio Gallery Slider
        08.10) Blog Gallery Slider
        08.11) Product Details Image Slider
        08.12) Similliar Product Slider
        08.13) Slider Activations Initializer
    09) Countdown Activation
    10) CounterUp Activation
    11) Wowjs Activation
    12) Pricebox State Active
    13) Blog Hover State
    14) Blog Social Action
    15) Popup Activations
        15.01) Video Pupup Activation
        15.02) Portfolio Image Popup Activation
        15.03) Portfolio Details Image Popup Activation
        15.04) Product Details Image Zoom Activation
        15.05) Popup Initializations
    16) Portfolio Filter
    17) Blog Masonry Active
    18) Range Slider Active
    19) Nice Slect Active
    20) Product Details Zoom
    21) Product Quantitybox
    22) Product Details Zoom Image Change
    23) Product Details Color & Size Active
    24) Product Rating Input
    25) Different Address Form
    26) Checkout Payment Method
    27) Scroll Up Active
    28) Modal Slick Conflict
    29) Sticky Header
    30) Parallax Active
    31) Particle Active
    32) Video Background Active
    33) Ajax Mailchimp
    34) Menu Overflow
    35) Particle Active
    36) Ripple Js Active
    37) Animated Headline Active
    38) Scroll To Section
    39) Initializer

===========================================================
    END INDEX
===========================================================
*/



(function ($) {
    'use strict';

    /* Color Customizer */
    function tmCustomizer() {
        var customizer = $('.tm-customizer');
        var dataColorCss = $('[data-color-css]');
        var currentColorfile = '';

        customizer.find('.tm-customizer-opener').on('click', function () {
            customizer.toggleClass('open');
        });

        customizer.find('.tm-customizer-colorbox').on('click', 'li', function () {
            $(this).addClass('active').siblings('li').removeClass('active');
            currentColorfile = $(this).data('colorfile');
            dataColorCss.attr('href', currentColorfile);
            document.cookie = 'hozoborol=' + $(this).data('colorfile');
        });

        var getCookie = document.cookie.split(';');

        function arraySearch() {
            for (var i = 0; i < getCookie.length; i++) {
                if (getCookie[i].indexOf('hozoborol') != -1) {
                    var getContent = getCookie[i].replace('hozoborol=', '');
                    dataColorCss.attr('href', getContent);
                }
            }
        }

        if (getCookie.length >= 1) {
            arraySearch();
        }

    }
    tmCustomizer();

    /* Custom Functions */
    jQuery.fn.exists = function () {
        return this.length > 0;
    };

    /* Preloader */
    $('.tm-preloader .tm-button').on('click', function () {
        $('.tm-preloader').fadeOut();
    });
    $(window).on('load', function () {
        $('.tm-preloader').fadeOut();
    });

    var sasna = {

        /* Meanmenu Activation */
        meanmenuActivation: function () {
            $('nav.tm-navigation').meanmenu({
                meanMenuContainer: '.tm-mobilenav',
                meanScreenWidth: '991',
                meanMenuOpen: '<i class="fas fa-bars"></i>',
                meanMenuClose: '<i class="fas fa-times"></i>'
            });
        },

        /* Inline Background Image */
        dataBgImage: function () {
            $('[data-bgimage]').each(function () {
                var imageUrl = $(this).data('bgimage');
                $(this).css({
                    'background-image': 'url(' + imageUrl + ')'
                });
            });
        },

        /* Header Search Form */
        haderSearchForm: function () {
            $('.header-searchtrigger').on('click', function (e) {
                e.preventDefault();
                $('.header-searchbox').toggleClass('is-visible');
            });

            $('.header-searchbox .search-close').on('click', function (e) {
                e.preventDefault();
                $(this).parents('.header-searchbox').removeClass('is-visible');
            });
        },

        /* Heroslider Height */
        herosliderHeight: function () {
            var headerHeight = $('.header').innerHeight();

            $('.heroslider-singleslider').css({
                'min-height': 'calc(100vh - ' + headerHeight + 'px)',
            });
        },

        /* Button Effect */
        buttonEffect: function () {
            $('.tm-button')
                .on('m ouseenter', function (e) {
                    var parentOffset = $(this).offset(),
                        relX = e.pageX - parentOffset.left,
                        relY = e.pageY - parentOffset.top;
                    $(this).find('b').css({
                        top: relY,
                        left: relX
                    });
                })
                .on('mouseout', function (e) {
                    var parentOffset = $(this).offset(),
                        relX = e.pageX - parentOffset.left,
                        relY = e.pageY - parentOffset.top;
                    $(this).find('b').css({
                        top: relY,
                        left: relX
                    });
                });
            $('[href="#"]').on('click', function () {
                return false;
            });
        },

        /* Slider Activations */
        sliderActivations: {

            /* Heroslider Activation */
            heroSliderActivation: function () {
                $('.heroslider-slider').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    fade: true,
                    arrows: false,
                    dots: true,
                    adaptiveHeight: false,
                    responsive: [{
                        breakpoint: 1201,
                        settings: {
                            adaptiveHeight: true
                        }
                    }]
                });
            },

            /* Heroslider Activation 2 */
            heroSliderActivation2: function () {
                $('.heroslider-slider-2').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    arrows: true,
                    prevArrow: '<button class="tm-slider-arrow-prev"><i class="fas fa-chevron-left"></i></button>',
                    nextArrow: '<button class="tm-slider-arrow-next"><i class="fas fa-chevron-right"></i></button>',
                    dots: false,
                    adaptiveHeight: false,
                    responsive: [{
                        breakpoint: 1201,
                        settings: {
                            adaptiveHeight: true
                        }
                    }]
                });
            },

            /* Feature Slider Activation */
            featureSliderActivation: function () {
                $('.features-slider-active').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    vertical: true,
                    arrows: false,
                    dots: true
                });
            },

            /* Testimonial Slider */
            testimonialSliderActivation: function () {
                $('.testimonial-slider-active').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 2,
                    slidesToScroll: 1,
                    arrows: false,
                    dots: false,
                    responsive: [{
                        breakpoint: 768,
                        settings: {
                            slidesToShow: 1,
                            slidesToScroll: 1
                        }
                    }]
                });
            },

            /* Testimonial Slider 2 */
            testimonialSlider2Activation: function () {
                $('.tm-testimonial2-contentslider').slick({
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    arrows: false,
                    dots: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    asNavFor: '.tm-testimonial2-videoslider'
                });
                $('.tm-testimonial2-videoslider').slick({
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    arrows: false,
                    asNavFor: '.tm-testimonial2-contentslider',
                    vertical: true,
                });

            },

            /* Product Vertical Slider */
            productVerticalSliderActivation: function () {
                $('.product-vertical-slider-active').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    vertical: true,
                    arrows: false,
                    dots: true
                });
            },

            /* Blog Slider Activation */
            blogSliderActivation: function () {
                $('.blog-slider-active').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 5,
                    slidesToScroll: 3,
                    arrows: false,
                    dots: false,
                    responsive: [{
                            breakpoint: 1800,
                            settings: {
                                slidesToShow: 4,
                            }
                        },
                        {
                            breakpoint: 1300,
                            settings: {
                                slidesToShow: 3,
                                slidesToScroll: 2,
                            }
                        },
                        {
                            breakpoint: 992,
                            settings: {
                                slidesToShow: 2,
                                slidesToScroll: 1,
                            }
                        },
                        {
                            breakpoint: 576,
                            settings: {
                                slidesToShow: 1,
                                slidesToScroll: 1
                            }
                        }
                    ]
                });
            },

            /* Brand Logo Slider */
            brandlogoSliderActivation: function () {
                $('.brandlogo-slider').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 5,
                    slidesToScroll: 3,
                    arrows: false,
                    dots: false,
                    responsive: [{
                            breakpoint: 992,
                            settings: {
                                slidesToShow: 3,
                                slidesToScroll: 1,
                            }
                        },
                        {
                            breakpoint: 768,
                            settings: {
                                slidesToShow: 2,
                                slidesToScroll: 1
                            }
                        },
                        {
                            breakpoint: 420,
                            settings: {
                                slidesToShow: 1,
                                slidesToScroll: 1
                            }
                        }
                    ]
                });
            },

            /* Portfolio Gallery Slider */
            portfolioGallerySliderActivation: function () {
                $('.tm-portfoliodetails-gallery').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    arrows: true,
                    prevArrow: '<button class="tm-slider-arrow-prev"><i class="fas fa-chevron-left"></i></button>',
                    nextArrow: '<button class="tm-slider-arrow-next"><i class="fas fa-chevron-right"></i></button>',
                    dots: false,
                });
            },

            /* Blog Gallery Slider */
            blogGallerySliderActivation: function () {
                $('.blogitem-imageslider').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 1,
                    slidesToScroll: 1,
                    arrows: true,
                    prevArrow: '<button class="tm-slider-arrow-prev"><i class="fas fa-chevron-left"></i></button>',
                    nextArrow: '<button class="tm-slider-arrow-next"><i class="fas fa-chevron-right"></i></button>',
                    dots: false,
                });
            },

            /* Product Details Image Slider */
            productDetailsImageSlider: function () {
                $('.tm-prodetails-thumbs').slick({
                    slidesToShow: 4,
                    slidesToScroll: 1,
                    arrows: false,
                    dots: false,
                    autoplay: true,
                    autoplaySpeed: 5000,
                });
            },

            /* Similliar Product Slider */
            similliarProductSlider: function () {
                $('.tm-similliar-products-slider').slick({
                    infinite: true,
                    autoplay: true,
                    autoplaySpeed: 5000,
                    slidesToShow: 3,
                    slidesToScroll: 1,
                    arrows: true,
                    prevArrow: '<button class="tm-slider-arrow-prev"><i class="fas fa-chevron-left"></i></button>',
                    nextArrow: '<button class="tm-slider-arrow-next"><i class="fas fa-chevron-right"></i></button>',
                    dots: false,
                    responsive: [{
                            breakpoint: 992,
                            settings: {
                                slidesToShow: 3,
                                slidesToScroll: 1,
                            }
                        },
                        {
                            breakpoint: 768,
                            settings: {
                                slidesToShow: 2,
                                slidesToScroll: 1
                            }
                        },
                        {
                            breakpoint: 576,
                            settings: {
                                slidesToShow: 1,
                                slidesToScroll: 1
                            }
                        }
                    ]
                });
            },

            /* Slider Activations Initializer ( Just Remove a single line if you want to disable any slider ) */
            init: function () {
                sasna.sliderActivations.heroSliderActivation();
                sasna.sliderActivations.heroSliderActivation2();
                sasna.sliderActivations.featureSliderActivation();
                sasna.sliderActivations.testimonialSliderActivation();
                sasna.sliderActivations.testimonialSlider2Activation();
                sasna.sliderActivations.productVerticalSliderActivation();
                sasna.sliderActivations.blogSliderActivation();
                sasna.sliderActivations.brandlogoSliderActivation();
                sasna.sliderActivations.portfolioGallerySliderActivation();
                sasna.sliderActivations.blogGallerySliderActivation();
                sasna.sliderActivations.productDetailsImageSlider();
                sasna.sliderActivations.similliarProductSlider();
            }

        },

        /* Countdown Activation */
        countdownActivation: function () {
            $('.tm-countdown').each(function () {
                var $this = $(this),
                    finalDate = $(this).data('countdown');
                $this.countdown(finalDate, function (event) {
                    $this.html(event.strftime(
                        '<div class="tm-countdown-pack tm-countdown-day"><h2 class="tm-countdown-count">%-D</h2><h5>Days</h5></div><div class="tm-countdown-pack tm-countdown-hour"><h2 class="tm-countdown-count">%-H</h2><h5>Hour</h5></div><div class="tm-countdown-pack tm-countdown-minutes"><h2 class="tm-countdown-count">%M</h2><h5>Min</h5></div><div class="tm-countdown-pack tm-countdown-seconds"><h2 class="tm-countdown-count">%S</h2><h5>Sec</h5></div>'));
                });
            });
        },

        /* CounterUp Activation */
        counterupActivation: function () {
            if ($('.odometer').length) {
                $(window).on('scroll', function () {
                    function winScrollPosition() {
                        var scrollPos = $(window).scrollTop(),
                            winHeight = $(window).height();
                        var scrollPosition = Math.round(scrollPos + (winHeight / 1.2));
                        return scrollPosition;
                    }
                    var elemOffset = $('.odometer').offset().top;
                    if (elemOffset < winScrollPosition()) {

                        $('.odometer').each(function () {
                            $(this).html($(this).data('count-to'));
                        });
                    }
                });
            }
        },

        /* Wowjs Activation */
        wowJsActive: function () {
            var wow = new WOW({
                boxClass: 'wow',
                animateClass: 'animated',
                offset: 0,
                mobile: true,
                live: true
            });
            wow.init();
        },

        /* Pricebox State Active */
        priceboxActiveState: function () {
            $('.tm-pricebox').each(function () {
                if ($(this).hasClass('is-active') == true) {
                    $(this).find('.tm-button').removeClass('tm-button-dark');
                }
            });
        },

        /* Blog Hover State */
        blogHoverState: function () {
            $('.blogitem').each(function () {
                $(this).on('mouseover', function () {
                    $(this).find('.blogitem-content').find('.tm-button').removeClass('tm-button-dark');
                }).on('mouseout', function () {
                    $(this).find('.blogitem-content').find('.tm-button').addClass('tm-button-dark');
                });
            });
        },

        /* Blog Social Action */
        blogSocialAction: function () {
            $('.blogitem').each(function () {
                $(this).find('.blogitem-share-trigger').on('click', function () {
                    $(this).toggleClass('is-active');
                    $(this).siblings('ul').toggleClass('is-visible');
                });
            });
        },

        stickySidebarActive: function () {
            var winWidth = $(window).width();
            if (winWidth > 991) {
                $('.sticky-sidebar').stickySidebar({
                    topSpacing: 0,
                    bottomSpacing: 30
                });
            }
        },

        /* Popup Activations */
        popupActivation: {

            /* Video Pupup Activation */
            videoPopup: function () {
                $('.tm-videobutton').lightGallery({
                    selector: 'a'
                });
            },

            /* Portfolio Image Popup Activation */
            portfolioImagePopup: function () {
                $('.tm-portfolio').lightGallery({
                    selector: '.zoom-button a',
                    thumbnail: false,
                });
            },

            /* Portfolio Details Image Popup Activation */
            portfolioDetailsImagePopup: function () {
                $('.tm-portfoliodetails-image').lightGallery({
                    selector: 'a',
                    thumbnail: false,
                });
            },

            /* Product Details Image Zoom Activation */
            productDetailsImageZoom: function () {
                $('.tm-prodetails-largeimage').lightGallery({
                    selector: '.tm-prodetails-zoomimage',
                    thumbnail: false,
                });
            },

            /* Popup Initializations */
            init: function () {
                sasna.popupActivation.videoPopup();
                sasna.popupActivation.portfolioImagePopup();
                sasna.popupActivation.portfolioDetailsImagePopup();
                sasna.popupActivation.productDetailsImageZoom();
            }
        },

        /* Portfolio Filter */
        portfolioFilter: function () {
            $('.tm-portfolio-wrapper').imagesLoaded({
                background: true
            }, function () {
                $('.tm-portfolio-wrapper').isotope({
                    itemSelector: '.tm-portfolio-item',
                    layoutMode: 'masonry',
                    masonry: {
                        columnWidth: 1,
                    }
                });
            });

            $('.tm-portfolio-buttons button').on('click', function () {
                var filterValue = $(this).attr('data-filter');
                $('.tm-portfolio-wrapper').isotope({
                    filter: filterValue
                });

                $('.tm-portfolio-buttons button').removeClass('is-active');
                $(this).addClass('is-active');
            });
        },

        /* Blog Masonry Active */
        blogMasonryActive: function () {
            $('.blog-masonry-active').masonry({
                itemSelector: '.blog-masonry-item'
            });
        },

        /* Range Slider Active */
        rangeSlider: function () {
            $('.tm-rangeslider').nstSlider({
                'left_grip_selector': '.tm-rangeslider-leftgrip',
                'right_grip_selector': '.tm-rangeslider-rightgrip',
                'value_bar_selector': '.tm-rangeslider-bar',
                'value_changed_callback': function (cause, leftValue, rightValue) {
                    $(this).parent().find('.tm-rangeslider-leftlabel').text(leftValue);
                    $(this).parent().find('.tm-rangeslider-rightlabel').text(rightValue);
                }
            });
        },

        /* Nice Slect Active */
        niceSelectActive: function () {
            $('select').niceSelect();
        },

        /* Product Details Zoom */
        productDetailsZoom: function () {
            $('.tm-prodetails-largeimage img').elevateZoom({
                gallery: 'image-gallery',
                galleryActiveClass: 'active',
                zoomWindowWidth: 300,
                zoomWindowHeight: 100,
                scrollZoom: false,
                zoomType: 'inner',
                cursor: 'crosshair'
            });
            $('.tm-prodetails-largeimage img').elevateZoom({
                gallery: 'image-gallery2',
                galleryActiveClass: 'active',
                zoomWindowWidth: 300,
                zoomWindowHeight: 100,
                scrollZoom: false,
                zoomType: 'inner',
                cursor: 'crosshair'
            });
        },

        /* Product Quantitybox */
        productQuantityBox: function () {
            $('.tm-quantitybox').append('<div class="decrement-button tm-quantitybox-button">-</i></div><div class="increment-button tm-quantitybox-button">+</div>');
            $('.tm-quantitybox-button').on('click', function () {
                var button = $(this);
                var quantityOldValue = button.parent().find('input').val();
                var quantityNewVal;
                if (button.text() == "+") {
                    quantityNewVal = parseFloat(quantityOldValue) + 1;
                } else {
                    if (quantityOldValue > 1) {
                        quantityNewVal = parseFloat(quantityOldValue) - 1;
                    } else {
                        quantityNewVal = 1;
                    }
                }
                button.parent().find('input').val(quantityNewVal);
            });
        },

        /* Product Details Zoom Image Change */
        productDetailsImageZoomChange: function () {
            $('.tm-prodetails-thumbs').find('a').on('click', function (e) {
                e.preventDefault();
                var largeImage = $(this).data('zoom-image');
                $('.tm-prodetails-largeimage').find('img').attr('data-zoom-image', largeImage);
                $('.tm-prodetails-zoomimage').attr('href', largeImage);
            });
        },

        /* Product Details Color & Size Active */
        productDetailsColorSize: function () {
            $('.tm-prodetails-color ul li, .tm-prodetails-size ul li').on('click', 'span', function (e) {
                e.preventDefault();
                $(this).parent('li').addClass('is-checked').siblings().removeClass('is-checked');
            });
        },

        /* Product Rating Input */
        productRatingInput: function () {
            $('.tm-rating-input').each(function () {
                $(this).find('span').on('mouseenter', function () {
                    $('.tm-rating-input span').addClass('active');
                    $(this).nextAll('span').removeClass('active');
                });

            });
        },

        /* Different Address Form */
        differentAddressFormToggle: function () {
            $('#billform-dirrentswitch').on('change', function () {
                if ($(this).is(':checked')) {
                    $('.tm-checkout-differentform').slideDown();
                } else {
                    $('.tm-checkout-differentform').slideUp();
                }
            });
        },

        /* Checkout Payment Method */
        checkoutPaymentMethod: function () {
            $('.tm-checkout-payment input[type="radio"]').each(function () {
                if ($(this).is(':checked')) {
                    $(this).siblings('.tm-checkout-payment-content').slideDown();
                }
                $(this).siblings('label').on('click', function () {
                    $('.tm-checkout-payment input[type="radio"]').prop('checked', false).siblings('.tm-checkout-payment-content').slideUp();
                    $(this).prop('checked', true).siblings('.tm-checkout-payment-content').slideDown();
                });
            });
        },

        /* Scroll Up Active */
        scrollUpActive: function () {
            $.scrollUp({
                scrollName: 'scrollUp',
                topDistance: '300',
                topSpeed: 1000,
                animation: 'fade',
                animationInSpeed: 1000,
                animationOutSpeed: 1000,
                scrollText: '<i class="fas fa-chevron-up"></i>',
                activeOverlay: false,
            });
        },

        /* Modal Slick Conflict */
        modalSlickConflict: function () {
            $('.tm-product-quickview').on('show.bs.modal', function () {
                $('.tm-prodetails-thumbs').slick('slickNext');
            });
        },

        /* Sticky Header */
        stickyHeader: function () {
            $(window).on('scroll', function () {
                var scrollPos = $(this).scrollTop();
                if (scrollPos > 220) {
                    $('.header').addClass('sticky-active');
                } else {
                    $('.header').removeClass('sticky-active');
                }
            });
        },

        /* Parallax Active */
        parallaxActive: function () {
            $('.tm-parallax').jarallax({
                speed: 0.2
            });
        },

        /* Video Background Active */
        videoBackgroundActive: function () {
            if ($('.tm-videobg').exists()) {
                $('.tm-videobg').YTPlayer({
                    autoplay: true
                });
            }
        },


        /* Ajax Mailchimp */
        ajaxMailchimp: function () {
            $('#tm-mailchimp-form').ajaxChimp({
                language: 'en',
                callback: mailChimpResponse,
                // ADD YOUR MAILCHIMP URL BELOW HERE!
                url: 'YOUR_MAILCHIMP_URL_HERE'
            });

            function mailChimpResponse(resp) {
                if (resp.result === 'success') {
                    $('.tm-mailchimp-success').html('' + resp.msg).fadeIn(900);
                    $('.tm-mailchimp-error').fadeOut(400);
                } else if (resp.result === 'error') {
                    $('.tm-mailchimp-error').html('' + resp.msg).fadeIn(900);
                }
            }
        },


        /* Menu Overflow */
        menuOverflow: function () {
            $('.tm-navigation ul li').on('mouseenter mouseleave', function (e) {
                if ($('ul', this).length) {
                    var listElem = $('ul:first', this);
                    var listElemOffset = listElem.offset();
                    var leftValue = listElemOffset.left - $('body').offset().left;
                    var widthValue = listElem.width();

                    if (listElem.find('ul').length) {
                        widthValue = listElem.width() * 2;
                    }

                    var docW = $('body').width();
                    var isEntirelyVisible = (leftValue + widthValue <= docW);

                    if (!isEntirelyVisible) {
                        $(this).addClass('overflow-element');
                    } else {
                        $(this).removeClass('overflow-element');
                    }
                }
            });
        },

        /* Particle Active */
        particleJsActive: function () {
            if ($('#particles-js').exists()) {
                particlesJS.load('particles-js', 'assets/json/particles.json', function () {
                    console.log('');
                });
            }
        },


        /* Ripple Js Active */
        rippleJsActive: function () {
            if ($('.tm-rippple-active').exists()) {
                $('.tm-rippple-active').ripples();
            }
        },

        /* Animated Headline Active */
        animatedHeadline: function () {
            $('.tm-animated-text').textillate({
                loop: true,
                autoStart: true,
                minDisplayTime: 4000,
                in: {
                    delayScale: 1.5,
                    delay: 100,
                    sync: false,
                    reverse: false,
                },
                out: {
                    delayScale: 1.5,
                    delay: 50,
                    sync: false,
                    reverse: false,
                },
            });
        },

        /* Scroll To Section */
        scrollToSection: function () {
            $('.hash-scroll-link').on('click', function (event) {
                event.preventDefault();
                var $anchor = $(this);
                var headerHeight = $('.tm-header-bottomside').height();
                $('html, body').stop().animate({
                    scrollTop: ($($anchor.attr('href')).offset().top - headerHeight)
                }, 1000);
            });
        },

        /* Scrollspy Active */
        scrollSpyActive: function () {
            var headerMiddleHeight = $('.header-bottomarea').height();
            $('.tm-navigation.tm-navigation-landingpage').scrollspy({
                offset: -1 * (headerMiddleHeight - 1),
                activeClass: 'current',
                animate: 'swing',
            });
        },

        /* Initializer */
        init: function () {
            sasna.meanmenuActivation();
            sasna.dataBgImage();
            sasna.haderSearchForm();
            sasna.herosliderHeight();
            sasna.buttonEffect();
            sasna.sliderActivations.init();
            sasna.countdownActivation();
            sasna.counterupActivation();
            sasna.wowJsActive();
            sasna.priceboxActiveState();
            sasna.blogHoverState();
            sasna.blogSocialAction();
            sasna.stickySidebarActive();
            sasna.popupActivation.init();
            sasna.portfolioFilter();
            sasna.blogMasonryActive();
            sasna.rangeSlider();
            sasna.niceSelectActive();
            sasna.productDetailsZoom();
            sasna.productQuantityBox();
            sasna.productDetailsImageZoomChange();
            sasna.productDetailsColorSize();
            sasna.productRatingInput();
            sasna.differentAddressFormToggle();
            sasna.checkoutPaymentMethod();
            sasna.scrollUpActive();
            sasna.modalSlickConflict();
            sasna.stickyHeader();
            sasna.parallaxActive();
            sasna.videoBackgroundActive();
            sasna.ajaxMailchimp();
            sasna.menuOverflow();
            sasna.particleJsActive();
            sasna.rippleJsActive();
            sasna.animatedHeadline();
            sasna.scrollToSection();
            sasna.scrollSpyActive();
        }
    };

    sasna.init();


})(jQuery);