$('.ajaxTable').each(function() {
    //var source = $(this).attr("ajaxurl");
    var source = "/itemajax";
    var DataTable = $(this).DataTable( {
        "order": [[ 0, 'asc' ]],
        "fnDrawCallback": function(){





            $('.skilltipzy').tooltipster({
                side: 'right',
                content: 'Loading...',
                animationDuration: 10,
                contentAsHTML: true,
                theme: ['aiontooltip'],
                // 'instance' is basically the tooltip. More details in the "Object-oriented Tooltipster" section.
                functionBefore: function(instance, helper) {


                    var $origin = $(helper.origin),
                        skillid = $origin.attr('skillid');
                    toollang = $origin.attr('skilltiplang');
                    classic = $origin.attr('classic');


                    // we set a variable so the data is only loaded once via Ajax, not every time the tooltip opens
                    if ($origin.data('loaded') !== true) {

                        $.get("https://aionpowerbook.com/powerbook/extensions/AionExtensions/skilltooltip.php?lang=" + toollang + "&id=" + skillid + "&classic=" + classic, function(data) {

                            // call the 'content' method to update the content of our tooltip with the returned data.
                            // note: this content update will trigger an update animation (see the updateAnimation option)
                            instance.content(data);

                            // to remember that the data has been loaded
                            $origin.data('loaded', true);
                        });
                    }
                }
            });


            $('.tooltipzy').tooltipster({
                side: 'right',
                content: 'Loading...',
                animationDuration: 10,
                contentAsHTML: true,
                theme: ['aiontooltip'],
                // 'instance' is basically the tooltip. More details in the "Object-oriented Tooltipster" section.
                functionBefore: function(instance, helper) {


                    var $origin = $(helper.origin),
                        toolid = $origin.attr('tooltipid');
                    toollang = $origin.attr('tooltiplang');
                    toolcount = $origin.attr('tooltipcount');
                    classic = $origin.attr('classic');


                    // we set a variable so the data is only loaded once via Ajax, not every time the tooltip opens
                    if ($origin.data('loaded') !== true) {

                        $.get("https://aionpowerbook.com/powerbook/extensions/AionExtensions/tooltip.php?lang=" + toollang + "&id=" + toolid + "&count=" + toolcount + "&classic=" + classic, function(data) {

                            // call the 'content' method to update the content of our tooltip with the returned data.
                            // note: this content update will trigger an update animation (see the updateAnimation option)
                            instance.content(data);

                            // to remember that the data has been loaded
                            $origin.data('loaded', true);
                        });
                    }
                }
            });

            $('.crafttooltipzy').tooltipster({
                side: 'bottom',
                content: 'Loading...',
                animationDuration: 10,
                contentAsHTML: true,
                theme: ['aiontooltip'],
                // 'instance' is basically the tooltip. More details in the "Object-oriented Tooltipster" section.
                functionBefore: function(instance, helper) {


                    var $origin = $(helper.origin),
                        toolid = $origin.attr('crafttooltipID');
                    toollang = $origin.attr('crafttooltiplang');
                    classic = $origin.attr('classic');


                    // we set a variable so the data is only loaded once via Ajax, not every time the tooltip opens
                    if ($origin.data('loaded') !== true) {

                        $.get("https://aionpowerbook.com/powerbook/extensions/AionExtensions/crafttooltip.php?lang=" + toollang + "&id=" + toolid + "&classic=" + classic, function(data) {

                            // call the 'content' method to update the content of our tooltip with the returned data.
                            // note: this content update will trigger an update animation (see the updateAnimation option)
                            instance.content(data);

                            // to remember that the data has been loaded
                            $origin.data('loaded', true);
                        });
                    }
                }
            });

        },
        ajax: {
            'url': source,
            'type': 'GET',
            'data': flatten
        },
        serverSide: true,
        columns: [
            {
                data: 'id'
            },
            {
                data: 'iconName',
                render: function (data, type, row, meta) {
                    var icon = row['iconName'].toLowerCase().replaceAll(".dds", "");
                    return "<img class='thumb' src='https://aionpowerbook.com/item/icon/" + icon + ".png' width='37' height='37' >";
                }
            },
            {
                data: 'name',
                render: function (data, type, row, meta) {
                    return "<a href='/item/" + row['id'] + "' class='col_" + row['quality'] + " bold' >"+row['name']+"</a>";
                }
            }
        ]
    });
});