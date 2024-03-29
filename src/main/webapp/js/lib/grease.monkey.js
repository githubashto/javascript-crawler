function startWatcher() {
    try {
        if (window != window.top || !window.document || !window.document.body || !window.location) {
            setInterval(function() {
                if (stopit)
                    stopit();
            }, 50);
            stopit();
            return;
        }
    } catch (ex) {
        stopit();
        return;
    }
    var wait_time = 60 * 1000;
    GM_setValue('startTime', (new Date()).getTime().toString());
    window.setInterval(function() {
        var startTime = parseInt(GM_getValue('startTime', null));
        var waitedHowLong = (new Date()).getTime() - startTime;
        if (waitedHowLong > wait_time)
            window.location = 'http://' + GM_getValue('domain', null);
    }, 500);
}

startWatcher();
function stopit() {
    try {
        window.stop();
        if (window.document && window.document.childNodes) {
            var nodes = window.document.childNodes;
            for ( var i = 0; i < nodes.length; i++) {
                nodes[i].parentNode.removeChild(nodes[i]);
            }
        }
    } catch (e) {
    }
}

window.addEventListener('load', function() {
    try {
        if (window != window.top || !window.document || !window.document.body || !window.location) {
            stopit();
            return;
        }
    } catch (ex) {
        stopit();
        return;
    }
    var domain = GM_getValue('domain', null);
    if (window.document.getElementById('crawler_set_url_reset')) {
        domain = window.location.host;
        GM_setValue('domain', domain);
    }

    if (!domain)
        return;

    if (window.location.host == domain)
        return;

    var hostDiv = document.createElement('input');
    hostDiv.setAttribute('id', 'crawler_set_url');
    hostDiv.setAttribute('type', 'hidden');
    hostDiv.setAttribute('value', domain);
    window.document.body.appendChild(hostDiv);
    var stamp = (new Date()).getTime() + 's';
    var sf = document.createElement('script');
    sf.setAttribute('type', 'text/javascript');
    sf.setAttribute('src', 'http://' + domain + '/js/core/crawler_loader.js?s=' + stamp);
    var head = document.getElementsByTagName('head');
    if (head) {
        head[0].appendChild(sf);
    }
}, true);
